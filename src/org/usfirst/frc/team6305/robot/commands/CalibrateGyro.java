package org.usfirst.frc.team6305.robot.commands;

import org.usfirst.frc.team6305.robot.Gyro;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class CalibrateGyro extends InstantCommand {

    public CalibrateGyro() {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called once when the command executes
    protected void initialize() {
    	Gyro.calibrate();
    }

}
