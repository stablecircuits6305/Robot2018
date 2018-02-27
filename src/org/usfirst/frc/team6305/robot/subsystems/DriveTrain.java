package org.usfirst.frc.team6305.robot.subsystems;


import org.usfirst.frc.team6305.robot.RobotMap;
import org.usfirst.frc.team6305.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	public static final double wheelDiameter = 6;
	public static final double pulsePerRevolution = 360;
	final double distanceperpulse = Math.PI*wheelDiameter/pulsePerRevolution;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Spark frontLeftDrive = new Spark(RobotMap.frontLeftDrive);
	Spark backLeftDrive = new Spark(RobotMap.backLeftDrive);
	Spark frontRightDrive = new Spark(RobotMap.frontRightDrive);
	Spark backRightDrive = new Spark(RobotMap.backRightDrive);
	
	Encoder rightEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	Encoder leftEncoder = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
	
	public static DriveTrain instance = new DriveTrain();
	
	public DriveTrain () {
		initEncoders();
	}
	
	public void initEncoders () {
		leftEncoder.setDistancePerPulse(distanceperpulse);
		leftEncoder.setSamplesToAverage(10);
		
		rightEncoder.setDistancePerPulse(5);
		rightEncoder.setSamplesToAverage(10);
	}
	
	public void drive (double leftSpeed, double rightSpeed) {
		frontLeftDrive.set(-leftSpeed);
		backLeftDrive.set(-leftSpeed);
		frontRightDrive.set(-rightSpeed);
		backRightDrive.set(-rightSpeed);
	}
	
	public void setLeftSpeed(double leftSpeed) {
		frontLeftDrive.set(leftSpeed);
		backLeftDrive.set(leftSpeed);
	}

	public void stop () {
		frontLeftDrive.set(0);
		backLeftDrive.set(0);
		frontRightDrive.set(0);
		backRightDrive.set(0);
	}
	
	public void resetEncoders () {
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
	public double getLeftEncoderValue () {
		// returns the rotation in degrees
		double degree = leftEncoder.get();
		return degree;
	}
	
	public double getRightEncoderValue () {
		double degree = rightEncoder.get();
		return degree;
	}
	
	public static DriveTrain getInstance () {
		return instance;
	}
	
    public void initDefaultCommand () {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TankDrive());
    }
}

