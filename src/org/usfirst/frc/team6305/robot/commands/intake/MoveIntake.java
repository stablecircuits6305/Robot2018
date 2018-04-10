package org.usfirst.frc.team6305.robot.commands.intake;

import org.usfirst.frc.team6305.robot.XboxController;
import org.usfirst.frc.team6305.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveIntake extends Command {

	Intake intake = Intake.getInstance();
	XboxController xbox = new XboxController();
	double speed;
	
    public MoveIntake(double spd) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	speed = spd;
    	requires(intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	intake.moveLeftIntake(speed);
    	intake.moveRightIntake(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
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
