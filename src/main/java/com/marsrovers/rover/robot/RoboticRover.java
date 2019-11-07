package com.marsrovers.rover.robot;

import com.marsrovers.space.CardinalDirection;

/**
 * Class that depicts robotic rover
 * @author fab
 *
 */
public class RoboticRover {
	private int x;
	private int y;
	private CardinalDirection direction;
	
	/**
	 * 
	 * @param x Starting X coordinate of plateau
	 * @param y Starting Y coordinate of plateau
	 * @param direction Starting cardinal direction towards which robot points
	 */
	public RoboticRover(int x, int y, CardinalDirection direction) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	/**
	 * 
	 * @return Current X coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * 
	 * @param x Current X coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * 
	 * @return Current Y coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * 
	 * @param y Current Y coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * 
	 * @return Current cardinal direction
	 */
	public CardinalDirection getDirection() {
		return direction;
	}

	/**
	 * 
	 * @param direction Current cardinal direction
	 */
	public void setDirection(CardinalDirection direction) {
		this.direction = direction;
	}
	
}
