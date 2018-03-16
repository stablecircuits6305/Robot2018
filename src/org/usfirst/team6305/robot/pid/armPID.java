package org.usfirst.team6305.robot.pid;

import org.usfirst.frc.team6305.robot.RobotMap;
import org.usfirst.frc.team6305.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class armPID {
	
	public static armPID instance = new armPID();
	PIDController pidController;
	//Arm arm = Arm.getInstance();
	double speed;
	
	Arm arm = Arm.getInstance();
	
	public static armPID getInstance(){
		return instance;
	}
	
	
	
	public void init(double targetAngle, double maxSpeed){
		PIDSource pidSource = new PIDSource(){
			@Override
			public void setPIDSourceType(PIDSourceType pidSource){
				
			}

			@Override
			public PIDSourceType getPIDSourceType() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public double pidGet() {
				double val = arm.getArmEnc();
				// TODO Auto-generated method stub
				return val;
			}
		
	};
	
	
	PIDOutput pidOutput = new PIDOutput(){
		@Override
		public void pidWrite(double output){
			speed = -output;
		}
	};
	
	final double kP = SmartDashboard.getNumber("Arm P", RobotMap.defaultArmP);
	final double kI = SmartDashboard.getNumber("Arm I", RobotMap.defaultArmI);
	final double kD = SmartDashboard.getNumber("Arm D", RobotMap.defaultArmD);
	
	pidController = new PIDController(kP, kI, kD, pidSource, pidOutput);
	pidController.setAbsoluteTolerance(2);
	pidController.setSetpoint(targetAngle);
	pidController.setOutputRange(-maxSpeed, maxSpeed);
	pidController.enable();
	System.out.println("Button is pressed");
	
	}
	
	public double getSpeed(){
		return speed;
	}
	
	public boolean onTarget(){
		return pidController.onTarget();
	}
	
	public void end(){
		pidController.disable();
		pidController.free();
	}

}
