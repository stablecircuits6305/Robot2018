package org.usfirst.frc.team6305.robot.auto;


import org.usfirst.frc.team6305.robot.commands.DrivePID;
import org.usfirst.frc.team6305.robot.commands.FullDrive;
import org.usfirst.frc.team6305.robot.commands.GyroTest;
import org.usfirst.frc.team6305.robot.commands.PickUp;
import org.usfirst.frc.team6305.robot.commands.ResetGyro;
import org.usfirst.frc.team6305.robot.commands.Wait;
import org.usfirst.frc.team6305.robot.commands.claw.OpenClaw;
import org.usfirst.frc.team6305.robot.commands.elevator.TimedElevator;
import org.usfirst.frc.team6305.robot.commands.intake.TimedIntake;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeft_Left_C1 extends CommandGroup {

    public AutoLeft_Left_C1() {
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
//    	addSequential(new Wait(1));
    	addParallel(new StartRelease());
    	addSequential(new ResetGyro());
    	addSequential(new DrivePID(140));
    	addSequential(new ResetGyro());
    	addSequential(new GyroTest(90));
    	addSequential(new ResetGyro());
    	addSequential(new DrivePID(24));
    	addSequential(new ResetGyro());
    	addSequential(new TimedIntake(.6, 0.6));
    	addSequential(new OpenClaw());
    	addSequential(new GyroTest(0));
    	addSequential(new DrivePID(-12));
    	addSequential(new TimedElevator(0.8, -0.5));
    }
}
