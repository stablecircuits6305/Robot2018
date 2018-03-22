package org.usfirst.frc.team6305.robot.auto;

import org.usfirst.frc.team6305.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class driveAuto extends Command {
	DriveTrain drive = DriveTrain.getInstance();
	Timer timer = new Timer();
	double targetSpeed;
	double time;

    public driveAuto(double speed, double wantedTime) {
    	
    	requires(drive);
    	targetSpeed = speed;
    	time = wantedTime;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(timer.get() < time) {
    		drive.drive(targetSpeed, -targetSpeed);
    		
    	}
    	if(timer.get() >= time) {
    		drive.drive(0, 0);
    	}
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	timer.stop();
    	timer.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
