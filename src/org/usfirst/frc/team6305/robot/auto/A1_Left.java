package org.usfirst.frc.team6305.robot.auto;

//import org.usfirst.frc.team6305.robot.arm.topArm;

import org.usfirst.frc.team6305.robot.commands.DrivePID;

import org.usfirst.frc.team6305.robot.commands.GyroTest;
//import org.usfirst.frc.team6305.robot.commands.outTake;
import org.usfirst.frc.team6305.robot.commands.resetGyro;
import org.usfirst.frc.team6305.robot.elevator.timedElevator;
import org.usfirst.frc.team6305.robot.intake.timedOutput;
import org.usfirst.frc.team6305.robot.output.switchOutput;
import org.usfirst.frc.team6305.robot.auto.getOut;


import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class A1_Left extends CommandGroup {

    public A1_Left() {
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
    	//addSequential(new AutoBaseline());
    	//A1 here is considered the left most side
    	//This case is when FMS data reads the left side of the switch is favored for us
    	
		addParallel(new getOut());
		addSequential(new DrivePID(165));
		addSequential(new GyroTest(92));
		addSequential(new resetGyro());
		addSequential(new DrivePID(24));
		addSequential(new timedOutput(0.5, 0.6));
		addSequential(new DrivePID(-12));
		addSequential(new timedElevator(0.6, -0.5));
		
    	
    }
}
