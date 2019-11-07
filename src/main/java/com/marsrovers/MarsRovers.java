package com.marsrovers;

import java.util.Scanner;

import com.marsrovers.rover.command.RoboticRoverCommandExecutor;
import com.marsrovers.rover.command.RoboticRoverCommandFactory;
import com.marsrovers.rover.robot.RoboticRover;
import com.marsrovers.space.CardinalDirection;

public class MarsRovers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String quit = "";
		while(!quit.equals("q")) {
			System.out.print("Starting X coordinate: ");
			int x = scan.nextInt();
			System.out.print("Starting Y coordinate: ");
			int y = scan.nextInt();
			System.out.print("Starting direction: ");
			String d = scan.next();
			System.out.print("Command sequence: ");
			String cmdSeq = scan.next();
			try {
				RoboticRover robot = new RoboticRover(x, y, CardinalDirection.valueOf(d.toUpperCase()));
				RoboticRoverCommandExecutor robotExec = new RoboticRoverCommandExecutor();
				RoboticRoverCommandFactory.getCommandList(robot, cmdSeq).stream().forEach(cmd -> robotExec.executeOperation(cmd));
				
				System.out.println("Final X coordinate: " + robot.getX());
				System.out.println("Final Y coordinate: " + robot.getY());
				System.out.println("Final direction: " + robot.getDirection());
				
				System.out.print("Press 'q' to quit, anything else to continue: ");
				quit = scan.next();
			} catch(Exception e) {
				e.printStackTrace();
			} 
		}

		scan.close();
	}

}
