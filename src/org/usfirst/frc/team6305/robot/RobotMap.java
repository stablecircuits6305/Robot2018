/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6305.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;	
	public static int frontLeftDrive = 0;
	public static int backLeftDrive = 1;
	public static int frontRightDrive = 3;
	public static int backRightDrive = 4;
	public static int elevator = 7;
	public static int leftWheels = 5;
	public static int rightWheels = 6;
	public static int compressor = 0;
	
	//public static int lRamp = 8;
	//public static int rRamp = 9;

	
	public static int clawSolenoid1 = 0;
	public static int clawSolenoid2 = 1;
	
	public static double defaultLeftP = 0.25;
	public static double defaultLeftI = 0;
	public static double defaultLeftD = 0;
	
	public static double defaultRightP = 0.25;
	public static double defaultRightI = 0;
	public static double defaultRightD = 0;

	public static double defaultElevatorP;
	public static double defaultElevatorI;
	public static double defaultElevatorD;
	
	public static double defaultGyroP = 0.1;
	public static double defaultGyroI = 0;
	public static double defaultGyroD = 0;
	public static int elevatorLimit = 6;
	public static int armLimit = 7;
	public static int arm = 8;
	public static double defaultArmP;
	public static double defaultArmI;
	public static double defaultArmD;
	
	public static double scaleHeightDefault= 72;
	public static double scaleHeightTall;
	public static double switchHeight = 9;
	public static double vaultHeight;
	public static int bottomLimit = 5;
	}
