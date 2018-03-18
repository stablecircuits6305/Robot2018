package org.usfirst.frc.team6305.robot.emergency;

import org.usfirst.frc.team6305.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class driveEmergency extends Command {
	
	DriveTrain driveTrain = DriveTrain.getInstance();
	
	
	double targetDistance;
	double botSpeed;

    public driveEmergency(double dist, double speed) {
    	
    	requires(driveTrain);
    	targetDistance = dist;
    	botSpeed = speed;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveTrain.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	driveTrain.drive(botSpeed, -botSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (driveTrain.getLeftEncoderValue() >= targetDistance && driveTrain.getRightEncoderValue() >= targetDistance);
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveTrain.stop();
    	driveTrain.resetEncoders();
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}

