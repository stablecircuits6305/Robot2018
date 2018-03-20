package org.usfirst.frc.team6305.robot.commands;

import org.usfirst.frc.team6305.robot.RobotMap;
import org.usfirst.frc.team6305.robot.subsystems.DriveTrain;
import org.usfirst.team6305.robot.pid.DriveDifferencePID;
import org.usfirst.team6305.robot.pid.LeftDrivePID;
import org.usfirst.team6305.robot.pid.RightDrivePID;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DrivePID extends Command {

	DriveTrain driveTrain = DriveTrain.getInstance();
	LeftDrivePID leftDrivePID = LeftDrivePID.getInstance();
	RightDrivePID rightDrivePID = RightDrivePID.getInstance();
	DriveDifferencePID driveDifferencePID = DriveDifferencePID.getInstance();
	double targetDistance;
	final double MAXSPEED = 0.5;
	
    public DrivePID(double dist) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveTrain);
    	targetDistance = dist;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveTrain.resetEncoders();
    	leftDrivePID.init(targetDistance, MAXSPEED);
    	rightDrivePID.init(targetDistance, MAXSPEED);
    	driveDifferencePID.init();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double additive = driveDifferencePID.getAdditive();
    	System.out.println("Drive additive: " + additive);
    	driveTrain.drive(leftDrivePID.getSpeed() + additive, rightDrivePID.getSpeed() - additive);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return leftDrivePID.onTarget() || rightDrivePID.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	leftDrivePID.end();
    	rightDrivePID.end();
    	driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
