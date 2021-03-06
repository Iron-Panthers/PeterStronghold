package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Intakes until banner sensor has been triggered
 */

public class StageTwoIntake extends Command {

    public StageTwoIntake() {
    	requires(Robot.stageTwo);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.stageTwo.intakeBall();
    }

    protected boolean isFinished() {
        return Robot.stageTwo.hasBall(); //TEST MEEEEE
    }

    protected void end() {
    	Robot.stageTwo.stopMotors();
    	System.out.println("I ENDED!");
    }

    protected void interrupted() {
    	end();
    	System.out.println("I INTERRUPTED!");
    }
}
