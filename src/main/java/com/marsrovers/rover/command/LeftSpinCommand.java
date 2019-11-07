package com.marsrovers.rover.command;

import com.marsrovers.rover.robot.RoboticRover;

/**
 * Command to make robot pointing direction on the left
 * @author fab
 *
 */
public class LeftSpinCommand implements RoboticRoverCommand {
	private RoboticRover robot;
	
	public LeftSpinCommand(RoboticRover robot) {
		super();
		this.robot = robot;
	}

	/**
	 * The result of command execution depends on the current cardinal direction robot is pointing
	 */
	@Override
	public void execute() {
		synchronized (robot) {
			robot.setDirection(robot.getDirection().getLeft());
		}
	}

}
