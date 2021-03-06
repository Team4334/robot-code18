package main.java.ca.fourthreethreefour.settings;

import java.io.File;

import main.java.ca.fourthreethreefour.module.actuators.MotorModule;
import main.java.ca.fourthreethreefour.module.actuators.MotorModule.Type;

/**
 * Contains all values {@link SettingsFile} can parse, as well as their keys and default values.
 * @author Trevor, but also Joel
 * 
 */
public interface Settings {
	
	
	public static Type toType(String type) {
		if (type.equalsIgnoreCase("talon_srx") || type.equalsIgnoreCase("talonsrx")) {
			return Type.TALON_SRX;
		}
		
		if (type.equalsIgnoreCase("victor_spx") || type.equalsIgnoreCase("victorspx")) {
			return Type.VICTOR_SPX;
		}
		
		return null;
	}

	
	SettingsFile settingsFile = new SettingsFile(new File("/settings.txt"));

    String AUTO_TYPE = settingsFile.getProperty("AUTO_TYPE", "center").toLowerCase().trim();
    String AUTO_TARGET = settingsFile.getProperty("AUTO_TARGET", "scale").toLowerCase().trim();
	
    boolean LOGGING_ENABLED = settingsFile.getBooleanProperty("LOGGING_ENABLED", false);
	
    double TURN_CURVE = settingsFile.getDoubleProperty("TURN_CURVE", 4.5);

    // Ports
	// TODO get default ports
	// int EXAMPLE_PORT = settingsFile.getIntProperty("EXAMPLE_PORT", [default port])
	int DRIVE_LEFT_1 = settingsFile.getIntProperty("DRIVE_LEFT_1", 0);
	int DRIVE_LEFT_2 = settingsFile.getIntProperty("DRIVE_LEFT_2", 1);
	int DRIVE_RIGHT_1 = settingsFile.getIntProperty("DRIVE_RIGHT_1", 2);
	int DRIVE_RIGHT_2 = settingsFile.getIntProperty("DRIVE_RIGHT_2", 3);

	int GEAR_SHIFTER_SOLENOID_1 = settingsFile.getIntProperty("GEAR_SHIFTER_SOLENOID_1", 1);
	int GEAR_SHIFTER_SOLENOID_2 = settingsFile.getIntProperty("GEAR_SHIFTER_SOLENOID_2", 0);

	double LOW_GEAR_THRESHOLD = settingsFile.getDoubleProperty("LOW_GEAR_THRESHOLD", 0.1);

	int ARM_MOTOR = settingsFile.getIntProperty("ARM_MOTOR", 7);
	double ARM_SPEED = settingsFile.getDoubleProperty("ARM_SPEED", 0.7);
	
	int INTAKE_LEFT = settingsFile.getIntProperty("INTAKE_LEFT", 4);
	int INTAKE_RIGHT = settingsFile.getIntProperty("INTAKE_RIGHT", 6);
	int INTAKE_ARM = settingsFile.getIntProperty("INTAKE_ARM", 5);
	
	double INTAKE_ARM_SPEED_UP = settingsFile.getDoubleProperty("INTAKE_ARM_SPEED_UP", 0.45);
	double INTAKE_ARM_SPEED_DOWN = settingsFile.getDoubleProperty("INTAKE_ARM_SPEED_DOWN", 0.2);
	
	double INTAKE_RELEASE_SPEED = settingsFile.getDoubleProperty("INTAKE_RELEASE_SPEED", 0.8);
	double INTAKE_SPEED = settingsFile.getDoubleProperty("INTAKE_SPEED", 0.8);
	
	int INTAKE_RELEASE_LENGTH = settingsFile.getIntProperty("INTAKE_RELEASE_LENGTH", 750);
	
	MotorModule.Type TYPE_DRIVE_LEFT_1 = toType(settingsFile.getProperty("TYPE_DRIVE_LEFT_1", "talonsrx"));
	MotorModule.Type TYPE_DRIVE_LEFT_2 = toType(settingsFile.getProperty("TYPE_DRIVE_LEFT_2", "talonsrx"));
	MotorModule.Type TYPE_DRIVE_RIGHT_1 = toType(settingsFile.getProperty("TYPE_DRIVE_RIGHT_1", "talonsrx"));
	MotorModule.Type TYPE_DRIVE_RIGHT_2 = toType(settingsFile.getProperty("TYPE_DRIVE_RIGHT_2", "talonsrx"));

	MotorModule.Type TYPE_ARM_MOTOR = toType(settingsFile.getProperty("TYPE_ARM_MOTOR", "talonsrx"));

	MotorModule.Type TYPE_INTAKE_LEFT = toType(settingsFile.getProperty("TYPE_INTAKE_LEFT", "talonsrx"));
	MotorModule.Type TYPE_INTAKE_RIGHT = toType(settingsFile.getProperty("TYPE_INTAKE_RIGHT", "talonsrx"));
	MotorModule.Type TYPE_INTAKE_ARM = toType(settingsFile.getProperty("TYPE_INTAKE_ARM", "talonsrx"));
	
	int CLAW_SOLENOID_1 = settingsFile.getIntProperty("CLAW_SOLENOID_1", 4);
	int CLAW_SOLENOID_2 = settingsFile.getIntProperty("CLAW_SOLENOID_2", 5);
	
	int FLEX_SOLENOID_1 = settingsFile.getIntProperty("FLEX_SOLENOID_1", 6);
	int FLEX_SOLENOID_2 = settingsFile.getIntProperty("FLEX_SOLENOID_2", 7);
	
	int ENCODER_LEFT_1 = settingsFile.getIntProperty("ENCODER_LEFT_1", 2);
	int ENCODER_LEFT_2 = settingsFile.getIntProperty("ENCODER_LEFT_2", 3);
	int ENCODER_RIGHT_1 = settingsFile.getIntProperty("ENCODER_RIGHT_1", 0);
	int ENCODER_RIGHT_2 = settingsFile.getIntProperty("ENCODER_RIGHT_2", 1);
	int ARM_POTENTIOMETER = settingsFile.getIntProperty("ARM_POTENTIOMETER", 2);
	int INTAKE_POTENTIOMETER = settingsFile.getIntProperty("INTAKE_POTENTIOMETER", 1);
	
	int XBOXCONTROLLER_1 = settingsFile.getIntProperty("XBOXCONTROLLER_1", 0);
	int XBOXCONTROLLER_2 = settingsFile.getIntProperty("XBOXCONTROLLER_2", 1);

	double TICKS_PER_INCH = settingsFile.getDoubleProperty("TICKS_PER_INCH", 82.4);
	
	// PID values
	double SPEED_P = settingsFile.getDoubleProperty("SPEED_P", 0.003);
	double SPEED_I = settingsFile.getDoubleProperty("SPEED_I", 0);
	double SPEED_D = settingsFile.getDoubleProperty("SPEED_D", 0.017);

	double TURN_P = settingsFile.getDoubleProperty("TURN_P", -0.0195);
	double TURN_I = settingsFile.getDoubleProperty("TURN_I", 0);
	double TURN_D = settingsFile.getDoubleProperty("TURN_D", -0.006);
	
	double ARM_P = settingsFile.getDoubleProperty("ARM_P", 2.1);
	double ARM_I = settingsFile.getDoubleProperty("ARM_I", 0);
	double ARM_D = settingsFile.getDoubleProperty("ARM_D", 1);

	double INTAKE_P = settingsFile.getDoubleProperty("INTAKE_P", 0.8);
	double INTAKE_I = settingsFile.getDoubleProperty("INTAKE_I", 0);
	double INTAKE_D = settingsFile.getDoubleProperty("INTAKE_D", 1);

	// absolute highest position of the arm, all PID setpoints are relative to this
	double ARM_PID_TOP = settingsFile.getDoubleProperty("ARM_PID_TOP", 3.85);
	double ARM_PID_LOW = ARM_PID_TOP - settingsFile.getDoubleProperty("ARM_PID_LOW", 0.58);
	double ARM_PID_MIDDLE = ARM_PID_TOP - settingsFile.getDoubleProperty("ARM_PID_MIDDLE", 0.38);
	double ARM_PID_HIGH = ARM_PID_TOP - settingsFile.getDoubleProperty("ARM_PID_HIGH", 0.02);
	double ARM_PID_START = ARM_PID_TOP - settingsFile.getDoubleProperty("ARM_PID_START", 0.8);
	double ARM_ANGLE_MIN = settingsFile.getDoubleProperty("ARM_ANGLE_MIN", 0.23);
	double ARM_ANGLE_MAX = settingsFile.getDoubleProperty("ARM_ANGLE_MAX", 0.39);
	
	double INTAKE_PID_BOTTOM = settingsFile.getDoubleProperty("INTAKE_PID_BOTTOM", 3.80);
	double INTAKE_PID_GROUND = INTAKE_PID_BOTTOM - settingsFile.getDoubleProperty("INTAKE_PID_GROUND", 0.25);
	double INTAKE_PID_SHOOTING = INTAKE_PID_BOTTOM - settingsFile.getDoubleProperty("INTAKE_PID_SHOOTING", 2.02);
	double INTAKE_PID_TOP = INTAKE_PID_BOTTOM - settingsFile.getDoubleProperty("INTAKE_PID_TOP", 2.80);
	double INTAKE_ANGLE_MIN = settingsFile.getDoubleProperty("INTAKE_ANGLE_MIN", 0.10);
	double INTAKE_ANGLE_MAX = settingsFile.getDoubleProperty("INTAKE_ANGLE_MAX", 0.61);
	double INTAKE_BACKDRIVE_SPEED = settingsFile.getDoubleProperty("INTAKE_BACKDRIVE_SPEED", 0.75);
	
	double INTAKE_PID_SPEED = settingsFile.getDoubleProperty("INTAKE_PID_SPEED", 0.6);
	double INTAKE_PID_SPEED_GROUND = settingsFile.getDoubleProperty("INTAKE_PID_SPEED_GROUND", 0.31);

	double DISTANCE_TOLERANCE = settingsFile.getDoubleProperty("DISTANCE_TOLERANCE", 50);
	double TURN_TOLERANCE = settingsFile.getDoubleProperty("TURN_TOLERANCE", 2);
	double INTAKE_TOLERANCE = settingsFile.getDoubleProperty("INTAKE_TOLERANCE", 0.5);
	
	double DRIVE_COMPENSATION = settingsFile.getDoubleProperty("DRIVE_COMPENSATION", 0);
}
