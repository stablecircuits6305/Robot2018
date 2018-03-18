package org.usfirst.team6305.robot.pid;

import org.usfirst.frc.team6305.robot.RobotMap;
import org.usfirst.frc.team6305.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LeftDrivePID {
	
	public static LeftDrivePID instance = new LeftDrivePID();
	
	DriveTrain driveTrain = DriveTrain.getInstance();
	PIDController pidController;
	double speed;
	
	public LeftDrivePID() {
		
	}
	
	public void init(double targetDistance, double maxSpeed) {
    	PIDSource pidSource = new PIDSource() {
			@Override
			public void setPIDSourceType(PIDSourceType pidSource) {}

			@Override
			public PIDSourceType getPIDSourceType() {
				// TODO Auto-generated method stub
				return PIDSourceType.kDisplacement;
			}

			@Override
			public double pidGet() {
				double leftVal = driveTrain.getLeftEncoderValue();
				System.out.println(leftVal);
				return leftVal;
			}
    	};
    	
    	PIDOutput pidOutput = new PIDOutput() {
			@Override
			public void pidWrite(double output) {
				speed = output;
			}
    	};
    	
    	final double kP = SmartDashboard.getNumber("Left P", RobotMap.defaultLeftP);
    	final double kI= SmartDashboard.getNumber("Left I", RobotMap.defaultLeftI);
    	final double kD= SmartDashboard.getNumber("Left D", RobotMap.defaultLeftD);
    	
    	pidController = new PIDController(kP, kI, kD, pidSource, pidOutput);
    	pidController.setAbsoluteTolerance(2);
    	pidController.setSetpoint(targetDistance);
    	pidController.setOutputRange(-maxSpeed, maxSpeed);
    	pidController.enable();
    	System.out.println("Button is pressed");
	}
	
	public double getSpeed () {
		return speed;
	}
	
	public boolean onTarget () {
		return pidController.onTarget();
	}
	
	public void end () {
		pidController.disable();
    	pidController.free();
	}
	
	public static LeftDrivePID getInstance() {
		return instance;
	}
	
}
