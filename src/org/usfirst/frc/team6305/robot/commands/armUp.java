package org.usfirst.frc.team6305.robot.commands;

import org.usfirst.frc.team6305.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class armUp extends Command {
	
	Arm arm= Arm.getInstance();
	double targetSpeed;
	

    public armUp(double speed) {
    	requires(arm);
    	targetSpeed = speed;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	arm.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	arm.up(targetSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	arm.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	arm.stop();
    }
}
