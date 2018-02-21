package org.usfirst.frc.team6305.robot.subsystems;

import org.usfirst.frc.team6305.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	static Elevator instance = new Elevator();
	Spark elevator = new Spark(RobotMap.elevator);
	DigitalInput elevatorLimit = new DigitalInput(RobotMap.elevatorLimit);
	
	public void moveElevator (double speed) {
		if (speed > 0) {
			if (elevatorLimit.get()) {
				elevator.set(speed);
			} else {
				stop();
			}
		} else {
			elevator.set(speed);
		}
	}
	
	public void stop () {
		elevator.stopMotor();
	}
	
	public static Elevator getInstance() {
		return instance;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
}

