package rodovia.eahunter.command;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.requests.restaction.MessageAction;

// TODO: Fazer o CommandManager

public interface Context {
	JDA getClient();
	Message getMessage();
	CommandManager getCommandManager();
	
	default void invoke(String command) {
		Command cmd = getCommandManager().getCommand(command);
		if (cmd != null) {
			cmd.run(this);
		}
	};
	
	default void invoke(String command, String... args) {		
		Command cmd = getCommandManager().getCommand(command);
		if (cmd != null) {
			cmd.run(this, args);
		}
	};
	
	default Guild getGuild() {
		if (!getMessage().isFromGuild())
			return null;
		
		return getMessage().getGuild();
	};

	default User getAuthor() {
		return getMessage().getAuthor();
	};
	
	default MessageChannel getChannel() {
		return getMessage().getChannel();
	};
	
	default Member getMember() {
		if (getGuild() == null)
			return null;
		
		return getMessage().getMember();
	};
	
	default MessageAction send(CharSequence message) {
		return getChannel().sendMessage(message);
	};
	
	default MessageAction send(Message message) {
		return getChannel().sendMessage(message);
	};
	
	default MessageAction reply(CharSequence message) {
		return getMessage().reply(message);
	}
	
	default MessageAction reply(Message message) {
		return getMessage().reply(message);
	};
	
}
