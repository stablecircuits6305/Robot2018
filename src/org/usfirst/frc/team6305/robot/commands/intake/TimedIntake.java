package org.usfirst.frc.team6305.robot.commands.intake;

import org.usfirst.frc.team6305.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class TimedIntake extends TimedCommand {

	Intake intake = Intake.getInstance();
	double speed;
	
    public TimedIntake(double timeout, double speed) {
        super(timeout);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(intake);
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	intake.moveLeftIntake(speed);
    	intake.moveRightIntake(speed);
    }

    // Called once after timeout
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
