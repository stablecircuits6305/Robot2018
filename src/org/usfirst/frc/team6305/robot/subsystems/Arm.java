package org.usfirst.frc.team6305.robot.subsystems;

import org.usfirst.frc.team6305.robot.RobotMap;
import org.usfirst.frc.team6305.robot.commands.HoldArm;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
	
	DigitalInput limitArm = new DigitalInput(RobotMap.armLimit);
	
	public static Arm instance = new Arm();
	Spark arm = new Spark(RobotMap.arm);
	Encoder armEnc = new Encoder(6,7, false, Encoder.EncodingType.k4X);
	
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void initEncoders(){
		armEnc.setDistancePerPulse(5);
		armEnc.setSamplesToAverage(10);
		
		armEnc.setDistancePerPulse(5);
		armEnc.setSamplesToAverage(10);
	}
	
	public void resetEncoders(){
		armEnc.reset();
		armEnc.reset();
	}
	
	public Arm(){
		initEncoders();
		arm.setInverted(true);
	}

	public void move(double speed){
		if(speed > 0){
			if(limitArm.get()){
				arm.set(speed);
			}else{
				stop();
			}
		}else{
			arm.set(speed);
		}
	}
	
	
	
	public void stop(){
		arm.set(0.2);
	}
	
	
	public double getArmEnc(){
		double val = armEnc.get();
		return val;
	}
	
	
	public static Arm getInstance(){
		return instance;
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new HoldArm());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

