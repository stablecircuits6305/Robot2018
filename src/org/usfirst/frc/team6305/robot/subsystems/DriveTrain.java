package org.usfirst.frc.team6305.robot.subsystems;

import org.usfirst.frc.team6305.robot.OI;
import org.usfirst.frc.team6305.robot.RobotMap;
import org.usfirst.frc.team6305.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Spark frontLeftDrive = new Spark(RobotMap.frontLeftDrive);
	Spark backLeftDrive = new Spark(RobotMap.backLeftDrive);
	Spark frontRightDrive = new Spark(RobotMap.frontRightDrive);
	Spark backRightDrive = new Spark(RobotMap.backRightDrive);
	
	Encoder rightEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	Encoder leftEncoder = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
	
	final double WHEEL_CIRCUM = Math.PI * 6;
	
	public static DriveTrain instance = new DriveTrain();
	
	public DriveTrain () {
		initEncoders();
	}
	
	public void initEncoders () {
		leftEncoder.setDistancePerPulse(5);
		leftEncoder.setSamplesToAverage(10);
		
		rightEncoder.setDistancePerPulse(5);
		rightEncoder.setSamplesToAverage(10);
	}
	
	public void drive (double leftSpeed, double rightSpeed) {
		frontLeftDrive.set(-leftSpeed);
		backLeftDrive.set(-leftSpeed);
		frontRightDrive.set(rightSpeed);
		backRightDrive.set(rightSpeed);
	}
	
	public void setLeftSpeed(double leftSpeed) {
		frontLeftDrive.set(-leftSpeed);
		backLeftDrive.set(-leftSpeed);
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
		// returns the rotation in inches
		double degree = leftEncoder.get();
		return (degree / 360) * WHEEL_CIRCUM;
	}
	
	public double getRightEncoderValue () {
		double degree = rightEncoder.get();
		return (degree / 360) * WHEEL_CIRCUM;
	}
	
	public static DriveTrain getInstance () {
		return instance;
	}
	
    public void initDefaultCommand () {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TankDrive());
    }
}

