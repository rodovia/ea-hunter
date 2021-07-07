package rodovia.eahunter.commands;

import rodovia.eahunter.command.Command;
import rodovia.eahunter.command.Context;

// N�O, o bot n�o vai ter comando de userinfo, � s� para testar a API de comandos.

public class UserInfoCommand extends Command {
	
	public UserInfoCommand() {
		this.name = "userinfo";
	}
	
	@Override
	protected void execute(Context ctx, String[] args) {
		ctx.reply("Ol�, Mundo!").queue();
	}
	
}
