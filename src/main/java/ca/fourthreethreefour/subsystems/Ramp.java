package main.java.ca.fourthreethreefour.subsystems;

import main.java.ca.fourthreethreefour.module.actuators.MotorModule;
import main.java.ca.fourthreethreefour.module.actuators.TalonSRXModule;
import main.java.ca.fourthreethreefour.module.actuators.TalonSRXModuleGroup;
import main.java.ca.fourthreethreefour.settings.Settings;
import edu.first.identifiers.InversedSpeedController;
import edu.first.module.Module;
import edu.first.module.actuators.SolenoidModule;
import edu.first.module.actuators.SpeedController;
import edu.first.module.actuators.SpeedControllerGroup;
import edu.first.module.subsystems.Subsystem;

public interface Ramp extends Settings {
	
	/**
	 * Allows TalonSRXModule's to be controlled using SpeedControllers commands, but considered
	 * as a Module for Subsystem.
	 * @author Cool, with major credit to Joel.
	 *
	 */
	
	MotorModule // Creates a TalonSRXModule for the left side and right
		leftRamp1 = new MotorModule(TYPE_RAMP_LEFT_1, RAMP_LEFT_1),
		leftRamp2 = new MotorModule(TYPE_DRIVE_LEFT_2, RAMP_LEFT_2),
		rightRamp1 = new MotorModule(TYPE_DRIVE_RIGHT_1, RAMP_RIGHT_1),
		rightRamp2 = new MotorModule(TYPE_RAMP_RIGHT_2, RAMP_RIGHT_2);
	
	RampWinch // Creates a module for the TalonSRXModule's designed for the RampWinch retraction.
		leftRamp = new RampWinch(leftRamp1, leftRamp2), //TODO Set correct TalonSRXModule to be reversed. First one is the reversed one
		rightRamp = new RampWinch(rightRamp1, rightRamp2);
	
	SolenoidModule // Creates a single action solenoid, with set ports.
		leftRelease = new SolenoidModule(RAMP_RELEASE_LEFT),
		rightRelease = new SolenoidModule(RAMP_RELEASE_RIGHT);
	
	// Makes a subsystem called ramp with parts above
	public Subsystem ramp = new Subsystem(new Module[] { leftRamp, rightRamp, leftRelease, rightRelease });
	
}
