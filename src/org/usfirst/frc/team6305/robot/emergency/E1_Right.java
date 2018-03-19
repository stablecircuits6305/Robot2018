package org.usfirst.frc.team6305.robot.emergency;

import org.usfirst.frc.team6305.robot.arm.topArm;

//import org.usfirst.frc.team6305.robot.commands.DrivePID;
import org.usfirst.frc.team6305.robot.auto.cubeAuto;
import org.usfirst.frc.team6305.robot.auto.getOut;
import org.usfirst.frc.team6305.robot.commands.GyroTest;
import org.usfirst.frc.team6305.robot.commands.outTake;
import org.usfirst.frc.team6305.robot.commands.pickUp;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team6305.robot.commands.resetGyro;
import org.usfirst.frc.team6305.robot.output.switchOutput;

/**
 *
 */
public class E1_Right extends CommandGroup {

    public E1_Right() {
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
    	//addSequential(new DrivePID(192));
		addSequential(new getOut());
		addSequential(new resetGyro());
    	addSequential(new driveEmergency(192, 0.5));
    	addSequential(new GyroTest(0));
    	addSequential(new GyroTest(-90));
    	//addSequential(new DrivePID(73.1));
		addSequential(new resetGyro());
    	addSequential(new driveEmergency(73.1, 0.5));
    	addSequential(new GyroTest(0));
    	addSequential(new switchOutput());
    	//addSequential(new DrivePID(-73.1));\
		addSequential(new resetGyro());
    	addSequential(new driveEmergency(-73.1, 0.5));
    	addSequential(new GyroTest(0));
    	addSequential(new GyroTest(90));
    	//addSequential(new DrivePID(60));
		addSequential(new resetGyro());
    	addSequential(new driveEmergency(60, 0.5));
    	addSequential(new GyroTest(0));
    	addSequential(new GyroTest(-90));
    	//addSequential(new DrivePID(102.75));
		addSequential(new resetGyro());
    	addSequential(new driveEmergency(102.75, 0.5));
    	addSequential(new GyroTest(0));
    	addSequential(new GyroTest(-90));
    	addSequential(new cubeAuto());
    }
}