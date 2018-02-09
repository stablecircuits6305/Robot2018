package PIDs;

import org.usfirst.frc.team6305.robot.RobotMap;
import org.usfirst.frc.team6305.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RightDrivePID {
	
	public static RightDrivePID instance = new RightDrivePID();
	DriveTrain driveTrain = DriveTrain.getInstance();
	PIDController pidController;
	double speed;
	
	public RightDrivePID() {
		
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
				double distance = driveTrain.getRightEncoderValue();
//				System.out.println(distance);
				return distance;
			}
    	};
    	
    	PIDOutput pidOutput = new PIDOutput() {
			@Override
			public void pidWrite(double output) {
				speed = -output;
			}
    	};
    	
    	final double kP = SmartDashboard.getNumber("Right P", RobotMap.defaultRightP);
    	final double kI= SmartDashboard.getNumber("Right I", RobotMap.defaultRightI);
    	final double kD= SmartDashboard.getNumber("Right D", RobotMap.defaultRightD);
    	
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
	
	public static RightDrivePID getInstance() {
		return instance;
	}
	
}
