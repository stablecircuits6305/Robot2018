package org.usfirst.frc.team6305.robot.subsystems;

import org.usfirst.frc.team6305.robot.RobotMap;

//import org.usfirst.frc.team6305.robot.intake.holdIntake;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class intake extends Subsystem {
	
	Spark rightWheels = new Spark(RobotMap.rightWheels);
	Spark leftWheels = new Spark(RobotMap.leftWheels);
	
	public static intake instance = new intake();

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
    	
    	
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void suckIn(double speed){
    	rightWheels.set(speed);
    	leftWheels.set(-speed);
    	
    }
    
    public void suckOut(double speed){
    	rightWheels.set(-speed);
    	leftWheels.set(speed);
    }
    
    public void stop(){
    	rightWheels.stopMotor();
    	leftWheels.stopMotor();
    }
    
    
    
    public static intake getInstance(){
    	return instance;
    }
    
    
}

