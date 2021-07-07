package rodovia.eahunter.command;

import java.util.HashMap;
import java.util.Map;

import rodovia.eahunter.errors.CommandRegistrationException;

public class CommandManager {
	
	private Map<String, Command> commands;
	
	public CommandManager() {
		commands = new HashMap<>();
	}
	
	public void addCommand(Command command) {
		if (commands.containsKey(command.getName())) {
			String message = String.format("The command %s already exists.", command.getName());
			throw new CommandRegistrationException(message);
		}
		
		commands.put(command.getName(), command);
	}
	
	public void addCommandMany(Command... commands) {
		for (Command command : commands) {
			addCommand(command);
		}
	}
	
	public Command getCommand(String name) {
		return commands.get(name);
	}
}
