package org.usfirst.frc.team5026.lib;
import org.usfirst.frc.team5026.robot.Constants;

import edu.wpi.first.wpilibj.Joystick;

public class PantherJoystick extends Joystick {
	
	public int power;
	public double m_deadzoneX;
	public double m_deadzoneY;
	double motorDeadZone;
	public double scalingX; // slope of joystick curve
	public double scalingY; // slope of joystick curve
	
	public PantherJoystick(int port, double deadzoneX, double deadzoneY, double driveMotorsDeadZone, double driveJoystickXScaling, double driveJoystickYScaling) {
		super(port);
		m_deadzoneX = deadzoneX;
		m_deadzoneY = deadzoneY;
		scalingX = driveJoystickXScaling;
		scalingY = driveJoystickYScaling;
		motorDeadZone = driveMotorsDeadZone;
		power = 1;
	}

	public double getXAxis() {
		double value;
		double negative = (Math.abs(getX()) / getX()); 
		double xAxis = getX() - negative * m_deadzoneX;
		
		if(Math.abs(getX()) > m_deadzoneX + Constants.JOYSTICK_X_DEADZONE_PERCENTAGE_OF_Y * Math.abs(getYAxis())) {
			if(xAxis < 0) {
				value = -Math.pow(Math.abs(xAxis), power);
			}
			else {
				value = Math.pow(Math.abs(xAxis), power);
			}
			value = scalingX * value + negative * motorDeadZone;
		}
		else {
			value = 0;
		}
		
		return value;
	}
	
	public double getYAxis() {
		double value;
		double negative = (Math.abs(getY()) / getY());
		double yAxis = getY() - negative * m_deadzoneY;
		
		if(Math.abs(getY()) > m_deadzoneY) {
			if(yAxis < 0) {
				value = -Math.pow(Math.abs(yAxis), power);
			}
			else {
				value = Math.pow(Math.abs(yAxis), power);
			}
			value = scalingY * value + negative * motorDeadZone;
		}
		else {
			value = 0;
		}
		return value;
	}

	

} 
