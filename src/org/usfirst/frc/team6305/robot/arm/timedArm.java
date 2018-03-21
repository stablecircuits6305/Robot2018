package org.usfirst.frc.team6305.robot.arm;

import org.usfirst.frc.team6305.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class timedArm extends TimedCommand {
	
	double targetSpeed;
	Arm arm = Arm.getInstance();

    public timedArm(double timeout, double speed) {
        super(timeout);
        requires(arm);
        targetSpeed = speed;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	arm.move(targetSpeed);
    }

    // Called once after timeout
    protected void end() {
    	arm.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
