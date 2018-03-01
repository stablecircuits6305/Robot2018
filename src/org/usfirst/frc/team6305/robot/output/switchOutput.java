package org.usfirst.frc.team6305.robot.output;

import org.usfirst.frc.team6305.robot.RobotMap;
import org.usfirst.frc.team6305.robot.commands.outTake;
import org.usfirst.frc.team6305.robot.elevator.elevatorSet;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class switchOutput extends CommandGroup {

    public switchOutput() {
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
    	addSequential(new elevatorSet(RobotMap.switchHeight));
    	addSequential(new outTake());
    	
    }
}
