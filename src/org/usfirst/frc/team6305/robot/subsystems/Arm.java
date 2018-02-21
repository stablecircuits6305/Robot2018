package org.usfirst.frc.team6305.robot.subsystems;

import org.usfirst.frc.team6305.robot.RobotMap;

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
	}

	public void up(double speed){
		if(speed > 0){
			if(limitArm.get()){
				arm.set(speed);
			}else{
				arm.set(0);
			}
		}
	}
	
	public void down(double speed){
		arm.set(-speed);
	}
	
	public void stop(){
		arm.set(0);
	}
	
	public void limit(){
		if(limitArm.get()){
			arm.stopMotor();
		}
	}
	public double getArmEnc(){
		double val = armEnc.get();
		return val;
	}
	
	
	public static Arm getInstance(){
		return instance;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

