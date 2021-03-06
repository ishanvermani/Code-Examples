/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6351.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static final double Drive_Scaling_Auto = 0.6;
	public static final double Drive_Scaling_Teleop = 0.8;
	public static final double Curve_Reduction_Factor = 0.95;
	
	public static final double JoystickDeadzone = 0.2;
	public static final double TriggerDeadzone = 0.2;

	public static final int Motor_Front_Left  = 1;
	public static final int Motor_Back_Left = 2;
	public static final int Motor_Front_Right = 3;
	public static final int Motor_Back_Right = 4;
	
	public static final double MAX_ROBOT_SPEED = 0.99;
	public static final double MIN_ROBOT_SPEED = -0.99;

	// Microsoft XBox Controller
	public static final int Controller1_Left_Y_Axis = 1;
	public static final int Controller1_Right_Y_Axis = 5;
	public static final int Controller1_Left_X_Axis = 0;
	public static final int Controller1_Right_X_Axis = 4;
	public static final int Controller1_Right_Trigger = 3;
	public static final int Controller1_Left_Trigger = 2;
	public static final int Controller1_Right_Bumper = 6;
	public static final int Controller1_Left_Bumper = 5;
	public static final int Controller1_A_Button = 1;
	public static final int Controller1_B_Button = 2;
	public static final int Controller1_X_Button = 3;
	public static final int Controller1_Y_Button = 4;	
	
	// Logitech Generic Controller
	public static final int Controller2_Right_Trigger = 8;
	public static final int Controller2_Left_Trigger = 7;
	public static final int Controller2_A_Button = 2;
	public static final int Controller2_B_Button = 3;
	public static final int Controller2_X_Button = 1;
	public static final int Controller2_Y_Button = 4;
	
	//LogitechJoystick
	public static final int Joy_Y_Axis = 1;
	public static final int Joy_Z_Axis = 2;
	public static final int Joy_X_Axis = 0;
	public static final int Joy_Throttle = 3;
	
	public static final int Joy_Button_10 = 10;
	public static final int Joy_Button_11 = 11;
	public static final int Joy_Button_12 = 12;
	public static final int Joy_Button_7 = 7;
	public static final int Joy_Button_3 = 3;
	public static final int Joy_Button_1 = 1;
}
