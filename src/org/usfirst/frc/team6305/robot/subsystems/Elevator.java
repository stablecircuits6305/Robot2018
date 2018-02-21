package org.usfirst.frc.team6305.robot.subsystems;

import org.usfirst.frc.team6305.robot.RobotMap;
import org.usfirst.frc.team6305.robot.commands.elevator.HoldElevator;

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
	final double HOLD_SPEED = 0.2;
	
	public Elevator () {
		elevator.setInverted(true);
	}
	
	public void moveElevator (double speed) {
		Boolean bool = elevatorLimit.get();
		System.out.println(bool);
		if (speed > 0.3) {
			if (bool) {
				elevator.set(speed);
			} else {
				stop();
			}
		} else {
			elevator.set(speed);
		}
	}
	
	public void stop () {
//		elevator.stopMotor();
		elevator.set(HOLD_SPEED);
	}
	
	public Boolean getLimit () {
		return elevatorLimit.get();
	}
	
	public static Elevator getInstance() {
		return instance;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new HoldElevator());
    }
}

