package org.usfirst.frc.team6305.robot.commands;

import org.usfirst.frc.team6305.robot.subsystems.Claw;
import org.usfirst.frc.team6305.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PickUpOp extends Command {
	
	Claw claw = Claw.getInstance();
	Intake intake = Intake.getInstance();
	double targetSpeed;

    public PickUpOp(double speed) {
    	requires(claw);
    	requires(intake);
    	targetSpeed = -speed;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	claw.close();
    	intake.moveLeftIntake(targetSpeed);
    	intake.moveRightIntake(targetSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	intake.stopLeft();
    	intake.stopRight();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
