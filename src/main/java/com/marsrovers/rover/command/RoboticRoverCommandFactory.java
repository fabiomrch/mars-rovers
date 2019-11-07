package com.marsrovers.rover.command;

import java.util.ArrayList;
import java.util.List;

import com.marsrovers.rover.exception.CommandNotFoundException;
import com.marsrovers.rover.robot.RoboticRover;

/**
 * This factory class helps with getting the right command by shortcut keys
 * @author fab
 *
 */
public class RoboticRoverCommandFactory {

	/**
	 * 
	 * @param robot RoboticRover subject to command
	 * @param shortcutKey shortcut key character ('M' = forward movement, 'L' = left spin, 'R' = right spin)
	 * @return Command corresponding to the shortcut key
	 * @throws CommandNotFoundException when shortcut key used is not valid
	 */
    public static RoboticRoverCommand getCommand(RoboticRover robot, char shortcutKey) throws CommandNotFoundException {
        switch (shortcutKey) {
            case 'M':
                return createForwardMovementCommand(robot);
            case 'L':
            	return createLeftSpinCommand(robot);
            case 'R':
                return createRightSpinCommand(robot);
             default:
            	 throw new CommandNotFoundException(String.format("Command not found for the shortcut key '%s'", shortcutKey));
        }
    }
    
    /**
     * 
     * @param robot RoboticRover subject to command
     * @param shortcutKeySequence String representing a sequence of shortcut keys
     * @return List of commands corresponding to the shortcut key sequence
     * @throws CommandNotFoundException when shortcut sequence contains invalid keys
     */
    public static List<RoboticRoverCommand> getCommandList(RoboticRover robot, String shortcutKeySequence) throws CommandNotFoundException {
		List<RoboticRoverCommand> commandList = new ArrayList<RoboticRoverCommand>();
    	
    	char[] shortcutKeys = shortcutKeySequence.toCharArray();
		for(char cmd : shortcutKeys)
		{
			commandList.add(RoboticRoverCommandFactory.getCommand(robot, cmd));
		}
		
		return commandList;
    }
    
    /**
     * Build a ForwardMovementCommand object
     * @param robot RoboticRover subject to command
     * @return ForwardMovementCommand object
     */
    public static ForwardMovementCommand createForwardMovementCommand(RoboticRover robot) {
        return new ForwardMovementCommand(robot);
    }
    
    /**
     * Build a LeftSpinCommand object
     * @param robot RoboticRover subject to command
     * @return LeftSpinCommand object
     */
    public static LeftSpinCommand createLeftSpinCommand(RoboticRover robot) {
        return new LeftSpinCommand(robot);
    }
    
    /**
     * Build a RightSpinCommand object
     * @param robot RoboticRover subject to command
     * @return RightSpinCommand object
     */
    public static RightSpinCommand createRightSpinCommand(RoboticRover robot) {
        return new RightSpinCommand(robot);
    }
}
