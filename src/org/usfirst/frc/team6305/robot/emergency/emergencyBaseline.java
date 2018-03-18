package org.usfirst.frc.team6305.robot.emergency;

import org.usfirst.frc.team6305.robot.commands.GyroTest;
import org.usfirst.frc.team6305.robot.commands.resetGyro;
import org.usfirst.frc.team6305.robot.elevator.elevatorAuto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class emergencyBaseline extends CommandGroup {

    public emergencyBaseline() {
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
    	addSequential(new resetGyro());
    	addSequential(new driveEmergency(120, 0.5));
    	addSequential(new GyroTest(0));
    	addSequential(new elevatorAuto(19));
    }
}
