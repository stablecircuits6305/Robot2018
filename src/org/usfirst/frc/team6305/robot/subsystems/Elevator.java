package org.usfirst.frc.team6305.robot.subsystems;

import org.usfirst.frc.team6305.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	DigitalInput limitElevator = new DigitalInput(RobotMap.elevatorLimit);
	
	
	Spark elevator = new Spark(RobotMap.elevator);
	Encoder elevatorEnc = new Encoder(4,5, false, Encoder.EncodingType.k4X);
	public static Elevator instance = new Elevator();

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void initEncoders(){
		elevatorEnc.setDistancePerPulse(5);
		elevatorEnc.setSamplesToAverage(10);
		
		elevatorEnc.setDistancePerPulse(5);
		elevatorEnc.setSamplesToAverage(10);
	}
	
	public void resetEncoders(){
		elevatorEnc.reset();
		elevatorEnc.reset();
	}
	
	public Elevator(){
		initEncoders();
	}

	public void up(double speed){
		elevator.set(speed);
		if(speed > 0){
		if(limitElevator.get()){
			elevator.set(speed);
		}else{
			stop();
		}
		}
	}
	
	public void down(double speed){
		elevator.set(-speed);
		if(limitElevator.get()){
			elevator.set(speed);
		}
		else{
			stop();
		}
	}
	
	public void stop(){
		elevator.set(0);
	}
	
	
	public double getElevatorEnc(){
		double val = elevatorEnc.get();
		return val;
	}
	
	
	public static Elevator getInstance(){
		return instance;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

