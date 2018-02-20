/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6305.robot;

import org.usfirst.frc.team6305.robot.auto.AutoBaseline;

import org.usfirst.frc.team6305.robot.auto.AutoLeft;
import org.usfirst.frc.team6305.robot.auto.AutoRight;
import org.usfirst.frc.team6305.robot.commands.TankDrive;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

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
	
	Command autoBaseline;

	Command teleopDrive, m_autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	NetworkTable autoTable;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
		Gyro.calibrate();
		Gyro.reset();
		m_oi = new OI();
		chooser.addDefault("Baseline", new AutoBaseline());
		chooser.addObject("Left Side", new AutoLeft());
		chooser.addObject("Right Side", new AutoRight());
		SmartDashboard.putData("Auto mode", chooser);
		teleopDrive = new TankDrive();
		autoBaseline = new AutoBaseline();
		NetworkTableInstance inst = NetworkTableInstance.getDefault();
		autoTable = inst.getTable("autoTable");
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

		
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
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData.charAt(0) == 'L') {}
			
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
		
		if(switchPosition.equals(true) && scalePosition.equals(true)){	
			m_autonomousCommand = autoBaseline;
		}
		// TODO: add code here to choose the proper auto

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
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
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
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		System.out.println("Gyro angle: " + Gyro.getAngle() + "  --  Gyro rate: " + Gyro.getRate());
	}
}
