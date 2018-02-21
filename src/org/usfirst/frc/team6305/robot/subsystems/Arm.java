package org.usfirst.frc.team6305.robot.subsystems;

import org.usfirst.frc.team6305.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	static Arm instance = new Arm();
	Spark arm = new Spark(RobotMap.arm);
	DigitalInput armLimit = new DigitalInput(RobotMap.armLimit);
	
	public void moveArm (double speed) {
		if (speed > 0) {
			if (armLimit.get()) {
				arm.set(speed);
			} else {
				stop();
			}
		} else {
			arm.set(speed);
		}
	}
	
	public void stop () {
		arm.stopMotor();
	}
	
	public static Arm getInstance () {
		return instance;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

