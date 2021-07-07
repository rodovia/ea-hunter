package rodovia.eahunter;

import java.util.List;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import net.dv8tion.jda.api.entities.SelfUser;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import rodovia.eahunter.command.Command;
import rodovia.eahunter.command.Context;
import rodovia.eahunter.command.ContextImpl;

public class EventListener extends ListenerAdapter {
	
	private static final Splitter ARGSPLITER = Splitter.on(' ')
						.trimResults()
						.omitEmptyStrings();
				
	@Override
	public void onReady(ReadyEvent event) {
		SelfUser user = event.getJDA().getSelfUser();
		System.out.println(String.format("Pronto como %#s (%s)", user, user.getId()));
	}
	
	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		if (!event.getMessage().getContentDisplay().startsWith(EAHunter.prefix())) {
			return;
		}
		
		Iterable<String> ssx = ARGSPLITER.split(event.getMessage().getContentRaw());
		
		List<String> preargs = Lists.newArrayList(ssx);
		// ignorar o nome do comando.
		String[] args = new String[0];
		if (preargs.size() > 1) {
			args = preargs.subList(1, preargs.size() - 1).toArray(new String[0]);
		}
		
		// String[] args = 
		Context ctx = new ContextImpl(event.getJDA(), event.getMessage());
		
		Command cmd = EAHunter.commandManager().getCommand(preargs.get(0).substring(1));
		if (cmd != null) {
			cmd.run(ctx, args);
		}
		
	}
	
}
