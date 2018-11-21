/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6351.robot.subsystems;

import org.usfirst.frc.team6351.robot.commands.Driving;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	VictorSP frontLeft = new VictorSP(1);
	VictorSP frontRight = new VictorSP(3);
	VictorSP backLeft = new VictorSP(2);
	VictorSP backRight = new VictorSP(4);
	
	SpeedControllerGroup m_left = new SpeedControllerGroup(frontLeft, backLeft);
	SpeedControllerGroup m_right = new SpeedControllerGroup(frontRight, backRight);
	
	public DifferentialDrive bot = new DifferentialDrive(m_left, m_right);
	
	public DriveTrain() {
		m_left.setInverted(true);
		m_right.setInverted(true);

		bot.setSafetyEnabled(true);
		bot.setExpiration(0.1);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new Driving());
	}
}
