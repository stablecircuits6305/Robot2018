package org.usfirst.frc.team6305.robot.auto;



import org.usfirst.frc.team6305.robot.commands.DrivePID;

import org.usfirst.frc.team6305.robot.commands.GyroTest;
import org.usfirst.frc.team6305.robot.commands.resetGyro;
import org.usfirst.frc.team6305.robot.elevator.elevatorAuto;
//import org.usfirst.frc.team6305.robot.subsystems.Arm;
//import org.usfirst.team6305.robot.pid.armPID;
//import org.usfirst.team6305.robot.pid.elevatorPID;

//import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoBaseline extends CommandGroup {

    public AutoBaseline() {
    	
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
    	//addSequential(new driveAuto(0.5, 2));
		addSequential(new getOut());
    	addSequential(new resetGyro());
    	addSequential(new DrivePID(120));
    	addSequential(new GyroTest(0));
    	addSequential(new elevatorAuto(19));
    	//addSequential(new armPID(5));
    	
    	
    	
    	}
    }

	

