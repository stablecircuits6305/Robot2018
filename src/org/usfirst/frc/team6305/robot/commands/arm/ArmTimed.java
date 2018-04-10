package org.usfirst.frc.team6305.robot.commands.arm;

import org.usfirst.frc.team6305.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class ArmTimed extends TimedCommand {

	Arm arm = Arm.getInstance();
	double targetSpeed;
	
    public ArmTimed(double timeout, double speed) {
        super(timeout);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(arm);
        targetSpeed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	arm.moveArm(targetSpeed);
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
