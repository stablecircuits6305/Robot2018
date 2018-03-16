package org.usfirst.frc.team6305.robot.elevator;

import org.usfirst.frc.team6305.robot.subsystems.Elevator;
import org.usfirst.team6305.robot.pid.elevatorPID;

//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class elevatorAuto extends Command {
	
	Elevator elevator = Elevator.getInstance();
	elevatorPID pid = elevatorPID.getInstance();
	
	final double MAXSPEED = 0.5;
	
	
	double targetDistance;

    public elevatorAuto(double dist) {
    	
    	requires(elevator);
    	targetDistance = dist;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	elevator.resetEncoders();
    	pid.init(targetDistance, MAXSPEED);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	elevator.move(pid.getSpeed());
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return pid.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	pid.end();
    	elevator.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
