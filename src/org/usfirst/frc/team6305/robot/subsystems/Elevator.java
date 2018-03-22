package org.usfirst.frc.team6305.robot.subsystems;

import org.usfirst.frc.team6305.robot.RobotMap;
import org.usfirst.frc.team6305.robot.elevator.HoldElevator;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	public DigitalInput limitElevator = new DigitalInput(RobotMap.elevatorLimit);
	//public DigitalInput bottomLimit = new DigitalInput(RobotMap.bottomLimit);
	
	
	
	Spark elevator = new Spark(RobotMap.elevator);
	/*
	int firstNum;
	int secondNum;
	Encoder elevatorEnc = new Encoder(firstNum,secondNum, false, Encoder.EncodingType.k4X);
	*/
	public static Elevator instance = new Elevator();

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	/*
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
	*/
	public Elevator(){
		//initEncoders();
		elevator.setInverted(true);
	}

	public void move(double speed){
		elevator.set(speed);
		if(speed > 0){
		if(limitElevator.get()){
			elevator.set(speed);
		}else{
			stop();
		}
			
		}else{
			elevator.set(speed);
		}
	}
	
	
	
	public void stop(){
		elevator.set(0.2);
	}
	
	/*
	public double getElevatorEnc(){
		double val = elevatorEnc.get();
		return val;
	}
	
	
	public void getBottomLimit() {
		System.out.println(bottomLimit);
	}
	*/
	
	public static Elevator getInstance(){
		return instance;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new HoldElevator());
    }
}

