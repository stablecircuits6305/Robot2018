package org.usfirst.team6305.robot.pid;

import org.usfirst.frc.team6305.robot.Gyro;
import org.usfirst.frc.team6305.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class DriveDifferencePID {
	
	public static DriveDifferencePID instance = new DriveDifferencePID();
	DriveTrain driveTrain = DriveTrain.getInstance();
	PIDController pidController;
	double additive;
	double MAX_ADDITIVE = 0.5;
	
	public DriveDifferencePID() {
		
	}
	
	public void init() {
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
//				double driveDifference = driveTrain.getLeftEncoderValue() - driveTrain.getRightEncoderValue();
				double driveDifference = Gyro.getAngle();
				return driveDifference;
			}
    	};
    	
    	PIDOutput pidOutput = new PIDOutput() {
			@Override
			public void pidWrite(double output) {
				additive = output;
			}
    	};
    	
//    	final double kP = SmartDashboard.getNumber("Left P", RobotMap.defaultLeftP);
//    	final double kI= SmartDashboard.getNumber("Left I", RobotMap.defaultLeftI);
//    	final double kD= SmartDashboard.getNumber("Left D", RobotMap.defaultLeftD);
    	final double kP = .05;
    	final double kI = 0;
    	final double kD = 0;
    	
    	pidController = new PIDController(kP, kI, kD, pidSource, pidOutput);
    	pidController.setAbsoluteTolerance(2);
    	pidController.setSetpoint(0);
    	pidController.setOutputRange(-MAX_ADDITIVE, MAX_ADDITIVE);
    	pidController.enable();
    	System.out.println("Button is pressed");
	}
	
	public double getAdditive () {
		return -additive;
	}
	
	public boolean onTarget () {
		return pidController.onTarget();
	}
	
	public void end () {
		pidController.disable();
    	pidController.free();
	}
	
	public static DriveDifferencePID getInstance() {
		return instance;
	}
	
}
