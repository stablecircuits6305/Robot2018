package org.usfirst.frc.team6305.robot.subsystems;

import org.usfirst.frc.team6305.robot.OI;
import org.usfirst.frc.team6305.robot.RobotMap;
import org.usfirst.frc.team6305.robot.commands.TankDrive;

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
	
	public static DriveTrain instance = new DriveTrain();
	
	public void drive (double leftSpeed, double rightSpeed) {
		frontLeftDrive.set(leftSpeed);
		backLeftDrive.set(leftSpeed);
		frontRightDrive.set(rightSpeed);
		backRightDrive.set(rightSpeed);
	}

	public void stop () {
		frontLeftDrive.set(0);
		backLeftDrive.set(0);
		frontRightDrive.set(0);
		backRightDrive.set(0);
	}
	
	public static DriveTrain getInstance () {
		return instance;
	}
	
    public void initDefaultCommand () {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TankDrive());
    }
}

