package org.usfirst.frc.team6305.robot.subsystems;

import org.usfirst.frc.team6305.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	static Intake instance = new Intake();
	Spark leftIntake = new Spark(RobotMap.leftIntake);
	Spark rightIntake = new Spark(RobotMap.rightIntake);
	
	public void moveLeftIntake (double speed) {
		leftIntake.set(speed);
	}
	
	public void moveRightIntake (double speed) {
		rightIntake.set(speed);
	}
	
	public void stopLeft () {
		leftIntake.stopMotor();
	}
	
	public void stopRight () {
		rightIntake.stopMotor();
	}
	
	public static Intake getInstance() {
		return instance;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

