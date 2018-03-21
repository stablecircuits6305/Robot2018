package org.usfirst.frc.team6305.robot.auto;

//import org.usfirst.frc.team6305.robot.arm.topArm;
import org.usfirst.frc.team6305.robot.auto.getOut;
import org.usfirst.frc.team6305.robot.commands.DrivePID;
import org.usfirst.frc.team6305.robot.commands.GyroTest;
//import org.usfirst.frc.team6305.robot.commands.outTake;
//import org.usfirst.frc.team6305.robot.commands.pickUp;
import org.usfirst.frc.team6305.robot.commands.resetGyro;
import org.usfirst.frc.team6305.robot.intake.timedOutput;
import org.usfirst.frc.team6305.robot.output.switchOutput;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class A1_Right extends CommandGroup {

    public A1_Right() {
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
    	//A1 is considered the left most side
    	//Case is for right side of the switch favoring us
    	addParallel(new getOut());
    	addSequential(new resetGyro());
    	addSequential(new DrivePID(225));
    	addSequential(new GyroTest(92));
    	addSequential(new resetGyro());
    	addSequential(new DrivePID(225));
    	addSequential(new GyroTest(92));
    	addSequential(new resetGyro());
    	addSequential(new DrivePID(50));
    	addSequential(new GyroTest(92));
    	addSequential(new resetGyro());
    	addSequential(new DrivePID(8));
    	addSequential(new timedOutput(0.5, 0.6));
    	
    }
}
