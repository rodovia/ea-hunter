package rodovia.eahunter.command;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;

public class ContextImpl implements Context {

	private JDA jda;
	private Message message;
	
	public ContextImpl(JDA jda, Message message) {
		this.jda = jda;
		this.message = message;
	}
	
	@Override
	public JDA getClient() {
		return jda;
	}

	@Override
	public Message getMessage() {
		return message;
	}

}
