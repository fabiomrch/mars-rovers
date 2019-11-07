package com.marsrovers.rover.command;

import com.marsrovers.rover.robot.RoboticRover;

/**
 * Command to make robot pointing direction on the right
 * @author fab
 *
 */
public class RightSpinCommand implements RoboticRoverCommand {
	private RoboticRover robot;
	
	public RightSpinCommand(RoboticRover robot) {
		super();
		this.robot = robot;
	}

	/**
	 * The result of command execution depends on the current cardinal direction robot is pointing
	 */
	@Override
	public void execute() {
		synchronized (robot) {
			robot.setDirection(robot.getDirection().getRight());
		}
	}

}
