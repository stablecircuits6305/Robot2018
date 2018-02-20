package org.usfirst.frc.team6305.robot.subsystems;

import org.usfirst.frc.team6305.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
	Spark arm = new Spark(RobotMap.arm);
	Encoder armEnc = new Encoder(6,7, false, Encoder.EncodingType.k4X);
	
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

