package org.usfirst.frc.team6305.robot.intake;

import org.usfirst.frc.team6305.robot.subsystems.intake;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class timedInput extends TimedCommand {
	double targetSpeed;
	intake in = intake.getInstance();

    public timedInput(double timeout, double speed) {
        super(timeout);
        targetSpeed = speed;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	in.suckIn(targetSpeed);
    }

    // Called once after timeout
    protected void end() {
    	in.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
}
