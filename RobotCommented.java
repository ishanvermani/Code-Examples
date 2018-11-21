/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


//PACKAGES: similar to folders, a way to organize files. This one is in the Robot Package/Folder
package org.usfirst.frc.team6351.robot;

//IMPORTS: Importing specific libraries, or pre-made code commands that have classes and methods pre made. Here we import the Command library
//which has all the command class information and code
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * IterativeRobot is a class which is based off the different modes of the robot. It is called
 * every 25ms
 */
public class RobotCommented extends IterativeRobot {
	
	//Below, The objects are declared. Private means it can only be called by this command, no other command can read the variables
	//The second word is the class which it will inherit characteristics from
	//For example, the motors will have the characteristics defined in the provided VictorSP Class
	//the third word is the name of the variable
	private VictorSP frontLeft;
	private VictorSP backLeft;
	private VictorSP frontRight;
	private VictorSP backRight;
	
	private XboxController controller;
	
	
	//SpeedControllerGroups group together motors that are on the same side
	private SpeedControllerGroup m_left;
	private SpeedControllerGroup m_right;
	
	//Differential drive creates a robot with a left motor and right motor. We give it motors and tell it how to drive
	private DifferentialDrive bot;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
		//Here we define the variables, when the robot starts
		//new means it is a new instance of that class
		//Then we tell it the class that it is a new instance of, and any values that it needs to fulfill that class
		//Here, the numbers are the pwm ports the controllers are plugged into
		frontLeft = new VictorSP(1);
		backLeft = new VictorSP(2);
		frontRight = new VictorSP(3);
		backRight = new VictorSP(4);
		
		// this is the port the controller is plugged into
		controller = new XboxController(0);
		
		//these are the motors in the group
		m_left = new SpeedControllerGroup(frontLeft, backLeft);
		m_right = new SpeedControllerGroup(frontRight, backRight);
		
		//this sets the motors inverted. Otherwise, when we go forward, we move backwards
		//the setInverted() command works for SpeedControllerGroups
		m_left.setInverted(true);
		m_right.setInverted(true);
		
		//Here we feed in the motors to create a DifferentialDrive class, which has predefined drive 
		//functions, commands, and algorithms.
		bot = new DifferentialDrive(m_left, m_right);
		
		// Setting the max and min speeds for the bot
		bot.setDeadband(0.1); //Min: all values below are ignored
		bot.setMaxOutput(1); //Max. All values are scaled from max to min over the entire rotation of the joytick
		
		// Motor safety feature, makes sure motors don't run without input
		bot.setSafetyEnabled(true);
		bot.setExpiration(0.1);
		
		
		
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional comparisons to
	 * the switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
	
		
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		//a double is a decimal
		//We are calling the variables in the execute() method because the values constantly change each cycle
		//The variables here are local to the method. They cannot be called anywhere else in this command (unless private is added)
		//We then call the controller, get the trigger axis, and define the hand
		//The value for hand needed for the command is part of the GenericHID.Hand library, so we called that
		double forward = controller.getTriggerAxis(GenericHID.Hand.kRight);
		double backward = controller.getTriggerAxis(GenericHID.Hand.kLeft);
		
		//Finally, we determine the speed by getting the sum of the forwards trigger and backwards trigger values
		double speed = forward - backward;
		
		//We then get the x value of the left joystick, which we use for turning
		double turn = controller.getX(GenericHID.Hand.kLeft);
		
		//All thats left is to call a drive command from our DifferentialDrive class
		//We feed it the speed and turn value
		//AND WE'RE HOT TO GO!!
		bot.arcadeDrive(speed, turn);
		
		//Y'ALL just coded
		/*
		 * Victory Lap!!
		 * bot.arcadeDrive(0, 10);
		 * 
		 */
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
