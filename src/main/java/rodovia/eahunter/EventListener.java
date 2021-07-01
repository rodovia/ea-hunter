package rodovia.eahunter;

import net.dv8tion.jda.api.entities.SelfUser;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EventListener extends ListenerAdapter {
	
	@Override
	public void onReady(ReadyEvent event) {
		SelfUser user = event.getJDA().getSelfUser();
		System.out.println(String.format("Pronto como %#s (%s)", user, user.getId()));
	}
	
	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		if (event.getMessage().getContentDisplay().equals("pai tenho fome")) {
			event.getMessage().reply("sou lindo").queue();
		}
	}
	
}
