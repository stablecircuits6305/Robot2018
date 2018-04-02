package org.usfirst.frc.team6305.robot.auto;


import org.usfirst.frc.team6305.robot.commands.DrivePID;
import org.usfirst.frc.team6305.robot.commands.GyroTest;
import org.usfirst.frc.team6305.robot.commands.ResetGyro;
import org.usfirst.frc.team6305.robot.commands.intake.TimedIntake;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeft_Right extends CommandGroup {

    public AutoLeft_Right() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	/*
    	addParallel(new StartRelease());
    	addSequential(new ResetGyro());
    	addSequential(new DrivePID(210));
    	addSequential(new ResetGyro());
    	addSequential(new GyroTest(92));
    	addSequential(new ResetGyro());
    	addSequential(new DrivePID(190));
    	addSequential(new ResetGyro());
    	addSequential(new GyroTest(92));
    	addSequential(new TimedIntake(0.5, 0.4));
    	*/
    	
      	//addParallel(new StartRelease());
    	addSequential(new ResetGyro());
    	addSequential(new DrivePID(233));
    	addSequential(new ResetGyro());
    	addSequential(new GyroTest(90));
    	addSequential(new ResetGyro());
    	addSequential(new DrivePID(222));
    	addSequential(new ResetGyro());
    	addSequential(new GyroTest(90));
    	addSequential(new ResetGyro());
    	addSequential(new DrivePID(63));
    	addSequential(new ResetGyro());
    	addSequential(new GyroTest(85));
    	addSequential(new ResetGyro());
    	addSequential(new DrivePID(16));
    	addSequential(new TimedIntake(0.5, 0.6));
    	
    	
    }
}
