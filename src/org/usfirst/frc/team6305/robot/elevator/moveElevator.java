package org.usfirst.frc.team6305.robot.elevator;

import org.usfirst.frc.team6305.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class moveElevator extends Command {
	
	Elevator elevator = Elevator.getInstance();
	double targetSpeed;
	Timer timer = new Timer();

    public moveElevator(double speed) {
    	requires(elevator);
    	targetSpeed = speed;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run/
    protected void execute() {
    	elevator.move(targetSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	timer.reset();
    	timer.start();
        return !elevator.limitElevator.get();
        
        
    }

    // Called once after isFinished returns true
    protected void end() {
    	if(timer.get() > 0.1) {
    		elevator.stop();
    		timer.reset();
    	}
    	
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	elevator.stop();
    }
}
