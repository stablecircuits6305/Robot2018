package org.usfirst.frc.team6305.robot.output;

import org.usfirst.frc.team6305.robot.RobotMap;
import org.usfirst.frc.team6305.robot.claw.clawOpen;
//import org.usfirst.frc.team6305.robot.commands.outTake;
//import org.usfirst.frc.team6305.robot.elevator.elevatorSet;
import org.usfirst.frc.team6305.robot.elevator.elevatorAuto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team6305.robot.intake.timedOutput;

/**
 *
 */
public class vaultOutput extends CommandGroup {

    public vaultOutput() {
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
    	
    	addSequential(new elevatorAuto(RobotMap.vaultHeight));
    	addParallel(new timedOutput(0.5, 0.5));
    	addSequential(new clawOpen());
    	
    }
}
