package org.usfirst.frc.team6305.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class Gyro {
		
	static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	
	/** 
	 * Calibrates gyro when the robot is stationary
	 */
	public static void calibrate () {
		gyro.calibrate();
	}
	
	/**
	 * @return angle turned from heading 
	 */
	public static double getAngle () {
		return gyro.getAngle();
	}
	
	/**
	 * @return rate of rotation
	 */
	public static double getRate () {
		return gyro.getRate();
	}
	
	/**
	 * Resets gyro back to heading 0
	 */
	public static void reset () {
		gyro.reset();
	}
}
