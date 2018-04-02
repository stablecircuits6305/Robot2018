package org.usfirst.frc.team6305.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	static Claw instance = new Claw();
	//DoubleSolenoid claw = new DoubleSolenoid(0, 1);
	
	public void open () {
//		claw.set(DoubleSolenoid.Value.kForward);
	}
	
	public void close () {
//		claw.set(DoubleSolenoid.Value.kReverse);
	}
	
	public static Claw getInstance () {
		return instance;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

