package org.usfirst.frc.team6305.robot.intake;


import org.usfirst.frc.team6305.robot.subsystems.intake;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class output extends Command {
	
	intake inTake;
	
    public output() {
    	inTake = intake.getInstance();
    	
    	
    	requires(inTake);
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	inTake.suckOut(.6);
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	inTake.stop();
    
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
