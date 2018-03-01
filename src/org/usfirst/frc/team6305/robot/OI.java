/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */

/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6305.robot;

import org.usfirst.frc.team6305.robot.claw.clawClose;
import org.usfirst.frc.team6305.robot.claw.clawOpen;
import org.usfirst.frc.team6305.robot.elevator.moveElevator;
//import org.usfirst.frc.team6305.robot.commands.pickUp;
//import org.usfirst.frc.team6305.robot.commands.scaleOutput;
//import org.usfirst.frc.team6305.robot.commands.switchOutput;
//import org.usfirst.frc.team6305.robot.commands.vaultOutput;
import org.usfirst.frc.team6305.robot.intake.input;
import org.usfirst.frc.team6305.robot.intake.output;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	
	public static JoystickButton leftButton1 = new JoystickButton(leftJoystick, 1);
	public static JoystickButton leftButton2 = new JoystickButton(leftJoystick, 2);
	public static JoystickButton leftButton3 = new JoystickButton(leftJoystick, 3);
	public static JoystickButton leftButton4 = new JoystickButton(leftJoystick, 4);
	
	public static JoystickButton rightButton1 = new JoystickButton(rightJoystick, 1);
	public static JoystickButton rightButton2 = new JoystickButton(rightJoystick, 2);
	public static JoystickButton rightButton3 = new JoystickButton(rightJoystick, 3);
	public static JoystickButton rightButton4 = new JoystickButton(rightJoystick, 4);
	
	public static XboxController xbox = new XboxController(2);
	
	static {
		
		if(SmartDashboard.getBoolean("Disabled Check", false)){
			if(OI.xbox.y.get() == true){
				SmartDashboard.putString("Robot Position", "A1");
			}
			
			else if(OI.xbox.b.get() == true){
				SmartDashboard.putString("Robot Position", "A2");
			}
			
			else if(OI.xbox.a.get() == true){
				SmartDashboard.putString("Robot Position", "A3");
			}
			
			else{
				SmartDashboard.putString("Robot Position", "Baseline");
			}
			

		}
		
		
		if(SmartDashboard.getBoolean("Teleop Check", false)){
			OI.xbox.dPad.up.whileHeld(new moveElevator(0.5));
			OI.xbox.dPad.down.whileHeld(new moveElevator(-0.5));
			OI.xbox.rt.whileHeld(new input());
			OI.xbox.lt.whileHeld(new output());
			OI.xbox.rb.whileHeld(new clawOpen());
			OI.xbox.rb.whileHeld(new clawClose());
			
			
			
			
			
			
			//OI.xbox.y.whenPressed(new scaleOutput());
			//OI.xbox.a.whenPressed(new switchOutput());
			//OI.xbox.b.whenPressed(new vaultOutput());
				
				
			}
		
		if(SmartDashboard.getBoolean("Test Check", false)){
			OI.leftButton1.whileHeld(new input());
			OI.rightButton1.whileHeld(new output());
			OI.leftButton2.whileHeld(new clawOpen());
			OI.rightButton2.whileHeld(new clawClose());
			//Put things here for testing
		}
		}
		
		
		
		
		
		
		//OI.button.whenPressed(new DrivePID(360));
		
		
		
		//OI.xbox.x.whenPressed(new GyroTest(90));
		
		
	
	}

