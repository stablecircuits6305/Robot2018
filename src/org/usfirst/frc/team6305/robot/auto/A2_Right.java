package org.usfirst.frc.team6305.robot.auto;

//import org.usfirst.frc.team6305.robot.arm.topArm;


import org.usfirst.frc.team6305.robot.commands.DrivePID;
import org.usfirst.frc.team6305.robot.commands.GyroTest;
//import org.usfirst.frc.team6305.robot.commands.outTake;
import org.usfirst.frc.team6305.robot.commands.resetGyro;
import org.usfirst.frc.team6305.robot.output.switchOutput;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class A2_Right extends CommandGroup {

    public A2_Right() {
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
		addSequential(new getOut());
    	addSequential(new resetGyro());
    	addSequential(new DrivePID(84));
    	addSequential(new GyroTest(0));
    	addSequential(new GyroTest(90));
    	addSequential(new resetGyro());
    	addSequential(new DrivePID(55.8));
    	addSequential(new GyroTest(0));
    	addSequential(new GyroTest(-90));
    	addSequential(new resetGyro());
    	addSequential(new DrivePID(108));
    	addSequential(new GyroTest(0));
    	addSequential(new GyroTest(-90));
    	addSequential(new switchOutput());
    	addSequential(new resetGyro());
    	addSequential(new DrivePID(-73.1));
    	addSequential(new GyroTest(0));
    	addSequential(new GyroTest(90));
    	addSequential(new resetGyro());
    	addSequential(new DrivePID(60));
    	addSequential(new GyroTest(90));
    	
    }
}
