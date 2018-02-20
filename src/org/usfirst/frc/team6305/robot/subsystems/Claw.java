package org.usfirst.frc.team6305.robot.subsystems;

import org.usfirst.frc.team6305.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {
	
	
	DoubleSolenoid claw = new DoubleSolenoid(RobotMap.clawSolenoid1, RobotMap.clawSolenoid2);
	
    
    
    public static Claw instance = new Claw();
		
    
   
	public void open(){
		claw.set(DoubleSolenoid.Value.kForward);
	}
	
	public void close(){
		claw.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void stop(){
		claw.set(DoubleSolenoid.Value.kOff);
		
	}
	
	public static Claw getInstance(){
		return instance;
	}
		
		

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

