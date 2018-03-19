/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */

/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6305.robot;

import edu.wpi.first.wpilibj.DriverStation;
import org.usfirst.frc.team6305.robot.auto.A1_Left;



import org.usfirst.frc.team6305.robot.auto.A1_Right;
import org.usfirst.frc.team6305.robot.auto.A2_Left;
import org.usfirst.frc.team6305.robot.auto.A2_Right;
import org.usfirst.frc.team6305.robot.auto.A3_Left;
import org.usfirst.frc.team6305.robot.auto.A3_Right;
import org.usfirst.frc.team6305.robot.auto.AutoBaseline;
//import org.usfirst.frc.team6305.robot.auto.driveAuto;
import org.usfirst.frc.team6305.robot.commands.TankDrive;
import org.usfirst.frc.team6305.robot.emergency.*;
import org.usfirst.frc.team6305.robot.subsystems.Elevator;

import edu.wpi.first.networktables.NetworkTable;
//import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
//import edu.wpi.first.wpilibj.DriverStation;
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
	
	Command autoBaseline;
	Command autoDrive;
	Command a1_left;
	Command a2_left;
	Command a3_left;
	Command a1_right;
	Command a2_right;
	Command a3_right;
	Command e1_left;
	Command e1_right;
	Command e2_left;
	Command e2_right;
	Command e3_left;
	Command e3_right;
	Compressor c;

	Command teleopDrive, m_autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	NetworkTable autoTable;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	
	@Override
	public void robotInit() {
		//autoDrive = new driveAuto(-0.5);
		Gyro.calibrate();
		Gyro.reset();
		m_oi = new OI();
		SmartDashboard.putString("Robot Mode", "Robot Init");
		SmartDashboard.putString("Robot Position", "Baseline");
		CameraServer.getInstance().startAutomaticCapture();
		/*
		 * 
		 */
		
		
	
		
		
		a1_left = new A1_Left();
		a1_right = new A1_Right();
		a2_left = new A2_Left();
		a2_right = new A2_Right();
		a3_left = new A3_Left();
		a3_right = new A3_Right();
		e1_left = new E1_Left();
		e1_right = new E1_Right();
		e2_left = new E2_Left();
		e2_right = new E2_Right();
		e3_left = new E3_Left();
		e3_right = new E3_Right();

		//chooser.addDefault("Baseline", new AutoBaseline());
		//chooser.addObject("A1_Left", new A1_Left());
		//chooser.addObject("A1_Right", new A1_Right());
		//chooser.addObject("A2_Left", new A2_Left());
		//chooser.addObject("A3_Left", new A3_Left());
		//chooser.addObject("A3_Right", new A3_Right());
		//SmartDashboard.putData("Auto mode", chooser);
		teleopDrive = new TankDrive();
		autoBaseline = new AutoBaseline();
		
		
		
		//NetworkTableInstance inst = NetworkTableInstance.getDefault();
		//autoTable = inst.getTable("autoTable");
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	
	@Override
	public void disabledInit() {
		SmartDashboard.putBoolean("Disabled Check", isDisabled());
		
		
		
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
		int nine;

		/*
		SmartDashboard.putBoolean("Teleop Check", isOperatorControl());
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();

		//NetworkTableEntry switchPosition = autoTable.getEntry("switchPosition");
		//NetworkTableEntry scalePosition = autoTable.getEntry("scalePosition");
		if (gameData.charAt(0) == 'L') {
			SmartDashboard.putBoolean("switchPosition", false);
			//switchPosition.setBoolean(false); // False is left, true is right
		} else {
			SmartDashboard.putBoolean("switchPosition", true);
			//switchPosition.setBoolean(true); // False is left, true is right

		}
		if (gameData.charAt(1) == 'L') {
			SmartDashboard.putBoolean("scalePosition", false);
			//scalePosition.setBoolean(false); // False is left, true is right
		} else {
			SmartDashboard.putBoolean("scalePosition", true);
			//scalePosition.setBoolean(true); // False is left, true is right
		}

		if(SmartDashboard.getString("Robot Position", "Baseline") == "A1"){
			if(SmartDashboard.getBoolean("switchPosition", false)){
				m_autonomousCommand = a1_right;
			}
			else{
				m_autonomousCommand = a1_left;
			}
		}

		else if(SmartDashboard.getString("Robot Position", "Baseline") == "A2"){
			if(SmartDashboard.getBoolean("switchPosition", false)){
				m_autonomousCommand = a2_right;
			}
			else{
				m_autonomousCommand = a2_left;
			}

		}

		else if(SmartDashboard.getString("Robot Position", "Baseline") == "A3"){
			if(SmartDashboard.getBoolean("switchPosition", false)){
				m_autonomousCommand = a3_right;
			}
			else{
				m_autonomousCommand = a3_left;

			}
		}

		else{
			m_autonomousCommand = autoBaseline;
		}*/
		m_autonomousCommand = autoBaseline;
		
		
		
		
		
		//
		
	
		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		SmartDashboard.putString("Robot Mode", "Auto Periodic");
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		SmartDashboard.putBoolean("Teleop Check", isOperatorControl());
		SmartDashboard.putString("Robot Mode", "Teleop Init");
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
		teleopDrive.start();
		
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		
		SmartDashboard.putBoolean("Teleop Check", isOperatorControl());
		SmartDashboard.putString("Robot Mode", "Teleop Periodic");
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override 
	
	public void testPeriodic() {
		teleopDrive.start();
		//Compressor c = new Compressor(RobotMap.compresser);
		//c.setClosedLoopControl(true);
		Elevator elevator = Elevator.getInstance();
		System.out.println(elevator.limitElevator.get());
		
		
		//System.out.println("Gyro angle: " + Gyro.getAngle() + "  --  Gyro rate: " + Gyro.getRate());
	}
}
