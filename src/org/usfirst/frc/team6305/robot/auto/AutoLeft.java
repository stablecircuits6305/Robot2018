package org.usfirst.frc.team6305.robot.auto;

import org.usfirst.frc.team6305.robot.commands.DrivePID;
import org.usfirst.frc.team6305.robot.commands.GyroTest;
import org.usfirst.frc.team6305.robot.commands.Levels;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeft extends CommandGroup {

    public AutoLeft() {
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
    	//All measurements are in inches
    	//Can be converted to feet
    	addSequential(new AutoBaseline());
    	addSequential(new DrivePID(84));
    	addSequential(new GyroTest(-90));
    	addSequential(new DrivePID(225));
    	addSequential(new GyroTest(90));
    	addSequential(new DrivePID(108));
    	addSequential(new GyroTest(90));
    	addSequential(new DrivePID(73.1));
    	addParallel(new Levels(30));
    	
    	
    	
    	
    }
}
