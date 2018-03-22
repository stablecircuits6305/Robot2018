package org.usfirst.frc.team6305.robot.arm;

import org.usfirst.frc.team6305.robot.subsystems.Arm;
import org.usfirst.team6305.robot.pid.armPID;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class armAuto extends Command {
	
	Arm arm = Arm.getInstance();
	armPID pid = armPID.getInstance();
	double targetDistance;
	final double MAXSPEED = 0.5;

    public armAuto(double dist) {
    	requires(arm);
    	targetDistance = dist;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//arm.resetEncoders();
    	pid.init(targetDistance, MAXSPEED);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	arm.move(pid.getSpeed());
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return pid.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	arm.stop();
    	pid.end();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
