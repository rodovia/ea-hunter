package rodovia.eahunter.commands;

import rodovia.eahunter.command.Command;
import rodovia.eahunter.command.Context;
import rodovia.eahunter.utils.ArgumentParser;
import rodovia.eahunter.utils.Arguments;

public class InfractionCommand extends Command {

	public InfractionCommand() {
		this.name = "infraction";
		this.aliases = new String[] {"infr"};
	}
	
	@Override
	protected void execute(Context ctx, String[] args) {
		Arguments arg = ArgumentParser.parseMentions(ctx, args);
	}
	
}
