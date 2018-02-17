package org.usfirst.team6305.robot.pid;

import org.usfirst.frc.team6305.robot.Gyro;
import org.usfirst.frc.team6305.robot.RobotMap;
import org.usfirst.frc.team6305.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GyroPID {
	public static GyroPID instance = new GyroPID();
	DriveTrain driveTrain = DriveTrain.getInstance();
	PIDController pidController;
	double speed;
	
	public GyroPID(){
		
	}
	
	public void init(double targetAngle, double maxSpeed){
		PIDSource pidSource = new PIDSource(){

			@Override
			public void setPIDSourceType(PIDSourceType pidSource) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public PIDSourceType getPIDSourceType() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public double pidGet() {
				double gyroVal = Gyro.getAngle();
				// TODO Auto-generated method stub
				return gyroVal;
			}
			
		};
		
		PIDOutput pidOutput = new PIDOutput(){

			@Override
			public void pidWrite(double output) {
				// TODO Auto-generated method stub
				speed = -output;
				
			}
			
		};
		
		final double kP = SmartDashboard.getNumber("Gyro P", RobotMap.defaultGyroP);
		final double kI = SmartDashboard.getNumber("Gyro I", RobotMap.defaultGyroI);
		final double kD = SmartDashboard.getNumber("Gyro D", RobotMap.defaultGyroD);
		
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

	public static GyroPID getInstance(){
		return instance;
	}
}
