package rodovia.eahunter.command;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import rodovia.eahunter.EAHunter;

public class ContextImpl implements Context {

	private JDA jda;
	private Message message;
	private CommandManager cmdman;
	
	public ContextImpl(JDA jda, Message message, CommandManager manager) {
		this.jda = jda;
		this.message = message;
		cmdman = manager;
	}
	
	public ContextImpl(JDA jda, Message message) {
		this.jda = jda;
		this.message = message;
		cmdman = EAHunter.commandManager();
	}
	
	@Override
	public JDA getClient() {
		return jda;
	}

	@Override
	public Message getMessage() {
		return message;
	}
	
	@Override
	public CommandManager getCommandManager() {
		return cmdman;
	}

}
