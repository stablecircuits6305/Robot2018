package org.usfirst.frc.team6305.robot.commands;

import org.usfirst.frc.team6305.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SlowDown extends Command {

	DriveTrain driveTrain = DriveTrain.getInstance();
	int i = 5;
	double mult = .6;
	
    public SlowDown() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveTrain.drive(driveTrain.getLastLeft() * mult, driveTrain.getLastRight());
    	i--;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (i <= 0);
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
