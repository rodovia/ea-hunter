package rodovia.eahunter.command;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.requests.RestAction;

// TODO: Fazer o CommandManager

public interface Context {
	JDA getClient();
	Message getMessage();
	
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
			throw new UnsupportedOperationException("Failed attempt of fetching the author as member in a DM context");
		
		return getMessage().getMember();
	};
	
	default RestAction<Message> send(CharSequence message) {
		return getChannel().sendMessage(message);
	};
	
	default RestAction<Message> send(Message message) {
		return getChannel().sendMessage(message);
	};
	
	default RestAction<Message> reply(CharSequence message) {
		return getMessage().reply(message);
	}
	
	default RestAction<Message> reply(Message message) {
		return getMessage().reply(message);
	};
	
}
