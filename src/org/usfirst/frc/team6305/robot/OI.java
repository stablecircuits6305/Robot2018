/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6305.robot;

import org.usfirst.frc.team6305.robot.XboxController;
import org.usfirst.frc.team6305.robot.auto.AutoLeft;
import org.usfirst.frc.team6305.robot.auto.AutoRight;
import org.usfirst.frc.team6305.robot.auto.ForwardDrive;
import org.usfirst.frc.team6305.robot.auto.StartRelease;
import org.usfirst.frc.team6305.robot.commands.ClawOutake;
import org.usfirst.frc.team6305.robot.commands.DrivePID;
import org.usfirst.frc.team6305.robot.commands.GyroTest;
import org.usfirst.frc.team6305.robot.commands.arm.MoveArm;
import org.usfirst.frc.team6305.robot.commands.claw.CloseClaw;
import org.usfirst.frc.team6305.robot.commands.claw.OpenClaw;
import org.usfirst.frc.team6305.robot.commands.elevator.MoveElevator;
import org.usfirst.frc.team6305.robot.commands.elevator.TimedElevator;
import org.usfirst.frc.team6305.robot.commands.intake.MoveIntake;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**  
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	
	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	public static Joystick leftJoystick = new Joystick(0);
	public static Joystick rightJoystick = new Joystick(1);
	
	public static JoystickButton leftTrigger = new JoystickButton(leftJoystick, 1);
	public static JoystickButton leftButton3 = new JoystickButton(leftJoystick, 3);
	public static JoystickButton leftButton4 = new JoystickButton(leftJoystick, 4);
	public static JoystickButton leftButton5 = new JoystickButton(leftJoystick, 5);
	public static JoystickButton leftButton6 = new JoystickButton(leftJoystick, 6);
	
	public static JoystickButton rightTrigger = new JoystickButton(rightJoystick, 1);
	public static JoystickButton rightButton3 = new JoystickButton(rightJoystick, 3);
	public static JoystickButton rightButton4 = new JoystickButton(rightJoystick, 4);
	
	
	public static XboxController xbox = new XboxController(2);
	
	static {
		
//		OI.leftTrigger.whenPressed(new GyroTest(-90));
//		OI.rightTrigger.whenPressed(new GyroTest(90));
//		OI.rightButton3.whenPressed(new DrivePID(180));
//		OI.rightButton4.whenPressed(new DrivePID(-180));
//		OI.leftTrigger.whenPressed();
//		OI.leftButton3.whileHeld(new MoveElevator(1));
//		OI.leftButton4.whileHeld(new MoveElevator(-.5));
//		OI.leftButton5.whileHeld(new MoveIntake(1));
//		OI.leftButton6.whileHeld(new MoveIntake(-1));
		
//		OI.rightTrigger.whenPressed(new CloseClaw());
//		OI.rightButton3.whileHeld(new MoveArm(0.6));
//		OI.rightButton4.whileHeld(new MoveArm(-0.2));
		
//		OI.rightTrigger.whenPressed(new AutoLeft());
//		OI.rightTrigger.whenPressed(new GyroTest(90));
		
		OI.xbox.rt.whileHeld(new MoveElevator(1));
		OI.xbox.lt.whileHeld(new MoveElevator(-0.8));
		OI.xbox.rb.whileHeld(new MoveArm(0.5));
		OI.xbox.lb.whileHeld(new MoveArm(-0.35));
		OI.xbox.y.whileHeld(new MoveIntake(0.4));
		OI.xbox.a.whileHeld(new OpenClaw());
		OI.xbox.x.whileHeld(new MoveIntake(-0.55));
		OI.xbox.b.whenPressed(new CloseClaw());
	}
}
