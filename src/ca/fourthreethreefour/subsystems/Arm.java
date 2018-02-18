package ca.fourthreethreefour.subsystems;

import ca.fourthreethreefour.module.actuators.TalonSRXModule;
import ca.fourthreethreefour.settings.Settings;
import edu.first.identifiers.Input;
import edu.first.module.Module;
import edu.first.module.actuators.DualActionSolenoid;
import edu.first.module.actuators.DualActionSolenoid.Direction;
import edu.first.module.actuators.DualActionSolenoidModule;
import edu.first.module.sensors.DigitalInput;
import edu.first.module.subsystems.Subsystem;

public interface Arm extends Settings {
	
	/*
	 * Creates DualActionSolenoidModules called clawSolenoid and flexSolenoid, with ports specified. 
	 */
	DualActionSolenoidModule 
		clawSolenoid = new DualActionSolenoidModule(CLAW_SOLENOID_1, CLAW_SOLENOID_2),
		flexSolenoid = new DualActionSolenoidModule(FLEX_SOLENOID_1, FLEX_SOLENOID_2);
	
	TalonSRXModule
		armMotor = new TalonSRXModule(ARM_MOTOR);
	
	DigitalInput highLimitSwitch = new DigitalInput(HIGH_LIMIT_SWITCH);
	DigitalInput lowLimitSwitch = new DigitalInput(LOW_LIMIT_SWITCH);
	
	// Creates subsystem of above for use in Robot.java
	Subsystem arm = new Subsystem(new Module[] {  clawSolenoid, flexSolenoid, armMotor });

	/*
	 *  Creates two directions that can be used in Autonomous for easy setting of their respective solenoid.
	 *  TODO Update these with correct direction.
	 */
	DualActionSolenoid.Direction 
		CLAW_CLOSE = Direction.LEFT,
		CLAW_OPEN = Direction.RIGHT,
		FLEX_EXTEND = Direction.LEFT,
		FLEX_RETRACT = Direction.RIGHT;	
}
