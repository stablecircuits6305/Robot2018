package org.usfirst.frc.team6305.robot.commands;

import org.usfirst.frc.team6305.robot.Gyro;
import org.usfirst.frc.team6305.robot.subsystems.DriveTrain;
import org.usfirst.team6305.robot.pid.GyroPID;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GyroTest extends Command {
	DriveTrain driveTrain = DriveTrain.getInstance();
	GyroPID gyroPID = GyroPID.getInstance();
	double targetAngle;
	final double MAXSPEED = 0.25;

    public GyroTest(double angle) {
    	
    	requires(driveTrain);
    	targetAngle = angle;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Gyro.reset();
    	gyroPID.init(targetAngle, MAXSPEED);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveTrain.drive(-gyroPID.getSpeed(), -gyroPID.getSpeed());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return gyroPID.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	gyroPID.end();
    	driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
