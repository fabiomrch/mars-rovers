package com.marsrovers.rover.command;

import com.marsrovers.rover.exception.CommandNotAllowedException;
import com.marsrovers.rover.robot.RoboticRover;

/**
 * Command to make robotic rover move forward on the plateu
 * @author fab
 *
 */
public class ForwardMovementCommand implements RoboticRoverCommand {

	private RoboticRover robot;
	
	public ForwardMovementCommand(RoboticRover robot) {
		super();
		this.robot = robot;
	}
	
	/**
	 * Move up: change current Y coordinate of robot
	 */
	private void up() {
		robot.setY(robot.getY() + 1);
	}
	
	/**
	 * Move down: change current Y coordinate of robot
	 * @throws CommandNotAllowedException (0, 0) represents the left bottom corner of the plateau
	 */
	private void down() throws CommandNotAllowedException {
		if(robot.getY() > 0)
			robot.setY(robot.getY() - 1);
		else
			throw new CommandNotAllowedException("RoboticRover cannot move further down the plateau");
	}
	
	/**
	 * Move left: change current X coordinate of robot
	 * @throws CommandNotAllowedException (0, 0) represents the left bottom corner of the plateau
	 */
	private void left() throws CommandNotAllowedException {
		if(robot.getX() > 0)
			robot.setX(robot.getX() - 1);
		else
			throw new CommandNotAllowedException("RoboticRover cannot move any further to the left");
	}
	
	/**
	 * Move right: change current X coordinate of robot
	 */
	private void right() {
		robot.setX(robot.getX() + 1);
	}
		
	/**
	 * The result of command execution depends on the current state of robot, particularly on cardinal direction robot is pointing
	 */
	@Override
	public void execute() {
		// CommandNotAllowedException is caught: it doesn't affect the movement of robot
		synchronized (robot) {
			try {
				switch (robot.getDirection()) {
					case N:
						up();
						break;
					case S:
						down();
						break;
					case W:
						left();
						break;
					case E:
						right();
						break;
				}
			} catch(CommandNotAllowedException e) {
				e.printStackTrace();
			}
		}
	}
}
