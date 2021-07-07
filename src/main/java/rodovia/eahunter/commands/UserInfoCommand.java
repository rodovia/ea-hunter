package rodovia.eahunter.commands;

import rodovia.eahunter.command.Command;
import rodovia.eahunter.command.Context;

// NÃO, o bot não vai ter comando de userinfo, é só para testar a API de comandos.

public class UserInfoCommand extends Command {
	
	public UserInfoCommand() {
		this.name = "userinfo";
	}
	
	@Override
	protected void execute(Context ctx, String[] args) {
		ctx.reply("Olá, Mundo!").queue();
	}
	
}
