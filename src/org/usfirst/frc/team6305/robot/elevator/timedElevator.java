package org.usfirst.frc.team6305.robot.elevator;

import org.usfirst.frc.team6305.robot.subsystems.Arm;
import org.usfirst.frc.team6305.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class timedElevator extends TimedCommand {
	
	double targetSpeed;
	Elevator elevator = Elevator.getInstance();

    public timedElevator(double timeout, double speed) {
        super(timeout);
        requires(elevator);
        targetSpeed = speed;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	elevator.move(targetSpeed);
    }

    // Called once after timeout
    protected void end() {
    	elevator.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
