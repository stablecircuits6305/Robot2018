package org.usfirst.frc.team6305.robot.commands.elevator;

import org.usfirst.frc.team6305.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class TimedElevator extends TimedCommand {

	Elevator elevator = Elevator.getInstance();
	double targetSpeed;
	
    public TimedElevator(double timeout, double speed) {
        super(timeout);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(elevator);
        targetSpeed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	elevator.moveElevator(targetSpeed);
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
