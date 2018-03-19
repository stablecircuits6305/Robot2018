package org.usfirst.frc.team6305.robot.commands;

//import org.usfirst.frc.team6305.robot.claw.clawClose;

import org.usfirst.frc.team6305.robot.claw.clawOpen;
//import org.usfirst.frc.team6305.robot.intake.input;
import org.usfirst.frc.team6305.robot.intake.output;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ClawOuttake extends CommandGroup {

    public ClawOuttake() {
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
    	addParallel(new clawOpen());
    	addParallel(new output(0.5));
    }
}
