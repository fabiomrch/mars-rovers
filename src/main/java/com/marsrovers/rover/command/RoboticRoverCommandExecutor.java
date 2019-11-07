package com.marsrovers.rover.command;

import java.util.ArrayList;
import java.util.List;

/**
 * This class performs and tracks the executions of commands, decouples the command objects from their consumers
 * @author fab
 *
 */
public class RoboticRoverCommandExecutor {
	private List<RoboticRoverCommand> commandSequence = new ArrayList<RoboticRoverCommand>();
	
    public void executeOperation(RoboticRoverCommand command) {
    	commandSequence.add(command);
        command.execute();
    }
}
