package org.usfirst.frc.team6305.robot.subsystems;

import org.usfirst.frc.team6305.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {
	
	
	
	DoubleSolenoid claw = new DoubleSolenoid(RobotMap.clawSolenoid1, RobotMap.clawSolenoid2);
	Compressor c= new Compressor(RobotMap.compresser);
	
    
    
    public static Claw instance = new Claw();
		
    
   
	public void open(){
		c.setClosedLoopControl(true);
		claw.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void close(){
		c.setClosedLoopControl(true);
		claw.set(DoubleSolenoid.Value.kForward);
	}
	
	public void stop(){
		claw.set(DoubleSolenoid.Value.kOff);
		//c.setClosedLoopControl(false);
		
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

