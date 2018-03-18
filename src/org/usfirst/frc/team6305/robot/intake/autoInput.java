package org.usfirst.frc.team6305.robot.intake;

import org.usfirst.frc.team6305.robot.subsystems.intake;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class autoInput extends TimedCommand {
	intake input = intake.getInstance();
	double targetSpeed;

    public autoInput(double timeout, double speed) {
        super(timeout);
        requires(input);
        targetSpeed = speed;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	input.suckIn(targetSpeed);
    }

    // Called once after timeout
    protected void end() {
    	input.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
