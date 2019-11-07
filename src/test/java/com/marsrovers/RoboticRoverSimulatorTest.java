package com.marsrovers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.marsrovers.rover.command.RoboticRoverCommandExecutor;
import com.marsrovers.rover.command.RoboticRoverCommandFactory;
import com.marsrovers.rover.exception.CommandNotFoundException;
import com.marsrovers.rover.robot.RoboticRover;
import com.marsrovers.space.CardinalDirection;

class RoboticRoverSimulatorTest {

	@Test
	public void checkResult() throws CommandNotFoundException {
		RoboticRover r1 = new RoboticRover(1, 2, CardinalDirection.N);
		RoboticRoverCommandExecutor r1CmdExec = new RoboticRoverCommandExecutor();
		String r1Cmd = "LMLMLMLMM";	
		RoboticRoverCommandFactory.getCommandList(r1, r1Cmd).stream().forEach(cmd -> r1CmdExec.executeOperation(cmd));
		assertEquals(r1.getX(), 1);
		assertEquals(r1.getY(), 3);
		assertEquals(r1.getDirection(), CardinalDirection.N);
		
		RoboticRover r2 = new RoboticRover(3, 3, CardinalDirection.E);
		RoboticRoverCommandExecutor r2CmdExec = new RoboticRoverCommandExecutor();
		String r2Cmd = "MMRMMRMRRM";
		RoboticRoverCommandFactory.getCommandList(r2, r2Cmd).stream().forEach(cmd -> r2CmdExec.executeOperation(cmd));
		assertEquals(r2.getX(), 5);
		assertEquals(r2.getY(), 1);
		assertEquals(r2.getDirection(), CardinalDirection.E);
		
		RoboticRover r3 = new RoboticRover(0, 0, CardinalDirection.S);
		RoboticRoverCommandExecutor r3CmdExec = new RoboticRoverCommandExecutor();
		String r3Cmd = "MLMRM";	
		RoboticRoverCommandFactory.getCommandList(r3, r3Cmd).stream().forEach(cmd -> r3CmdExec.executeOperation(cmd));
		assertEquals(r3.getX(), 1);
		assertEquals(r3.getY(), 0);
		assertEquals(r3.getDirection(), CardinalDirection.S);
		
		RoboticRover r4 = new RoboticRover(0, 0, CardinalDirection.S);
		RoboticRoverCommandExecutor r4CmdExec = new RoboticRoverCommandExecutor();
		String r4Cmd = "MRMLM";	
		RoboticRoverCommandFactory.getCommandList(r4, r4Cmd).stream().forEach(cmd -> r4CmdExec.executeOperation(cmd));
		assertEquals(r4.getX(), 0);
		assertEquals(r4.getY(), 0);
		assertEquals(r4.getDirection(), CardinalDirection.S);
	}

	@Test
	public void checkError() throws CommandNotFoundException {
		RoboticRover r1 = new RoboticRover(0, 0, CardinalDirection.N);
		String r1Cmd = "LMXMLMLMM";	
		assertThrows(CommandNotFoundException.class, () -> { RoboticRoverCommandFactory.getCommandList(r1, r1Cmd); });
		
	}
}
