/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6351.robot;

import org.usfirst.frc.team6351.robot.commands.Driving;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public Joystick theStickOfJoy = new Joystick(0);
	
	Button eh = new JoystickButton(theStickOfJoy, RobotMap.Controller1_A_Button);
	
	public OI() {
		eh.whenPressed(new Driving());
	}
	
}
