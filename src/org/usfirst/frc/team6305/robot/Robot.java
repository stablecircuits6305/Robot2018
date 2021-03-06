/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6305.robot;

import org.usfirst.frc.team6305.robot.auto.AutoBaseline;


import org.usfirst.frc.team6305.robot.auto.AutoLeft_Left_C1;
import org.usfirst.frc.team6305.robot.auto.AutoLeft_Left_Full;
import org.usfirst.frc.team6305.robot.auto.AutoLeft_Right;
import org.usfirst.frc.team6305.robot.auto.AutoRight_Left;
import org.usfirst.frc.team6305.robot.auto.AutoRight_Right_C1;
import org.usfirst.frc.team6305.robot.auto.AutoRight_Right_Full;
import org.usfirst.frc.team6305.robot.commands.CalibrateGyro;
import org.usfirst.frc.team6305.robot.commands.TankDrive;
//import org.usfirst.frc.team6305.robot.commands.arm.returnLimit;
import org.usfirst.frc.team6305.robot.subsystems.DriveTrain;
import org.usfirst.frc.team6305.robot.subsystems.Elevator;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static OI m_oi;
	Command teleopDrive;
	CameraServer camera = CameraServer.getInstance();
	Command autoCommand;
	SendableChooser<Integer> chooser = new SendableChooser<Integer>();
	SendableChooser<Boolean> collisionAvoiderChooser = new SendableChooser<Boolean>();
	NetworkTable autoTable;
	DriveTrain driveTrain;
	Compressor c;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		camera.startAutomaticCapture();
		Gyro.calibrate();
		Gyro.reset();
		m_oi = new OI();
//		chooser.addDefault("Baseline", new AutoBaseline());
		chooser.addDefault("Baseline", 0); // Baseline
		chooser.addObject("Left Side", 1); // Left Side
		chooser.addObject("Right Side", 2); // Right Side
	    SmartDashboard.putData("Auto mode", chooser);
	    collisionAvoiderChooser.addDefault("Pass Switch", true);
	    collisionAvoiderChooser.addObject("Don't Pass Switch", false);
	    SmartDashboard.putData("Collision Avoider", collisionAvoiderChooser);
	    
		teleopDrive = new TankDrive();
		autoCommand = null;
		driveTrain = DriveTrain.getInstance();
		NetworkTableInstance inst = NetworkTableInstance.getDefault();
		autoTable = inst.getTable("autoTable");
		c = new Compressor(0);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		c.setClosedLoopControl(false);
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		//Gyro.calibrate();
		
		c.setClosedLoopControl(true);
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		NetworkTableEntry switchPosition = autoTable.getEntry("switchPosition");
		NetworkTableEntry scalePosition = autoTable.getEntry("scalePosition");
		if (gameData.charAt(0) == 'L') {
			switchPosition.setBoolean(false); // False is left, true is right
		} else {
			switchPosition.setBoolean(true); // False is left, true is right
		}
		if (gameData.charAt(1) == 'L') {
			scalePosition.setBoolean(false); // False is left, true is right
		} else {
			scalePosition.setBoolean(true); // False is left, true is right
		}
		int auto = (int) chooser.getSelected();
		Boolean goPast = collisionAvoiderChooser.getSelected();
		/*
		switch(auto) {
		case 1:
			if(switchPosition.getBoolean(false)) {
				if(goPast)autoCommand = new AutoLeft_Right();
				else autoCommand = new AutoBaseline();
			}
			else {
				if(goPast) autoCommand = new AutoLeft_Left_Full();
				else autoCommand = new AutoLeft_Left_C1();
			}
			break;
		case 2:
			if(switchPosition.getBoolean(false)) {
				if(goPast) autoCommand = new AutoRight_Right_Full();
				else autoCommand = new AutoRight_Right_C1();
			}
			else {
				if(goPast) autoCommand = new AutoRight_Left();
				else autoCommand = new AutoBaseline();
			}
			break;
		default:
			autoCommand = new AutoBaseline();
		}
		*/
		
		
		if(auto == 0) {
			autoCommand = new AutoBaseline();
		}
		else if(auto == 1) {
			if (switchPosition.getBoolean(false)) {
				if (goPast)
					autoCommand = new AutoLeft_Right();
				else
					autoCommand = new AutoBaseline();
			} else {
				if (goPast)
					autoCommand = new AutoLeft_Left_Full();
				else
					autoCommand = new AutoLeft_Left_C1();
			}
		}
		else if(auto == 2) {
			if (switchPosition.getBoolean(false)) {
				if (goPast)
					autoCommand = new AutoRight_Right_Full();
				else
					autoCommand = new AutoRight_Right_C1();
			} else {
				if (goPast)
					autoCommand = new AutoRight_Left();
				else
					autoCommand = new AutoBaseline();
			}	
		}
		else {
			autoCommand = new AutoBaseline();
		}
		
			

		// schedule the autonomous command (example)
		if (autoCommand != null) {
			
			
			autoCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		c.setClosedLoopControl(true);
		if (autoCommand != null) {
			autoCommand.cancel();
		}
		teleopDrive.start();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	Elevator arm = Elevator.getInstance();
	@Override
	public void testPeriodic() {
//		System.out.println("Gyro angle: " + Gyro.getAngle() + "  --  Gyro rate: " + Gyro.getRate());
		int choice = (int) chooser.getSelected();
		/*
		switch(choice) {
		default:
			System.out.println("Baseline");
		    break;
		case 1:
			System.out.println("Left Side");
		    break;
		case 2:
			System.out.println("Right Side");
		    break;
		}
		*/
//		
//		
//		if(choice == 0) {
//			System.out.println("Baseline");
//		}
//		else if(choice == 1) {
//			System.out.println("Left Side");
//		}
//		else if(choice == 2) {
//			System.out.println("Right Side");
//		}
//		Command armCheck = new returnLimit();
//		armCheck.start();
//		
//		SmartDashboard.putNumberArray("Drive Encoders", new Double[]{driveTrain.getLeftEncoderValue(), driveTrain.getRightEncoderValue()});
//		SmartDashboard.putNumber("Gyro rate", Gyro.getRate());
//		System.out.println(arm.getLimit());
	}
}
