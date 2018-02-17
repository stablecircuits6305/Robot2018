package org.usfirst.frc.team6305.robot.commands;


import org.usfirst.frc.team6305.robot.subsystems.Claw;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class intake extends Command {
	Claw claw;
	
    public intake() {
    	claw = Claw.getInstance();
    	requires(claw);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	claw.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	claw.input();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	claw.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
