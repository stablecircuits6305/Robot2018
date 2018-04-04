package org.usfirst.frc.team6305.robot.auto;


import org.usfirst.frc.team6305.robot.commands.DrivePID;
import org.usfirst.frc.team6305.robot.commands.FullDrive;
import org.usfirst.frc.team6305.robot.commands.GyroTest;
import org.usfirst.frc.team6305.robot.commands.PickUp;
import org.usfirst.frc.team6305.robot.commands.ResetGyro;
import org.usfirst.frc.team6305.robot.commands.elevator.TimedElevator;
import org.usfirst.frc.team6305.robot.commands.intake.TimedIntake;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeft_Left extends CommandGroup {

    public AutoLeft_Left() {
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
    	addParallel(new StartRelease());
    	addSequential(new ResetGyro());
    	//This adds a drivePID in a sequential way
    	addSequential(new DrivePID(170));
    	addSequential(new GyroTest(90));
    	addSequential(new ResetGyro());
    	addSequential(new DrivePID(18));
    	addSequential(new TimedIntake(0.5, 0.4));
    	addSequential(new ResetGyro());
    	addSequential(new DrivePID(-12));
//    	addSequential(new TimedElevator(0.6, -0.5));
    	addSequential(new GyroTest(-90));
    	addSequential(new ResetGyro());
    	addSequential(new DrivePID(69));
    	addSequential(new GyroTest(90));
    	addSequential(new ResetGyro());
    	addSequential(new DrivePID(60));
    	addSequential(new GyroTest(90));
    	addSequential(new ResetGyro());
    	addSequential(new DrivePID(15));
    	addSequential(new TimedIntake(0.5, -0.4));
//    	addSequential(new PickUp());
//    	addSequential(new TimedElevator(0.6, 0.5));
    	addSequential(new DrivePID(10));
    	
    	
    	
    }
}
