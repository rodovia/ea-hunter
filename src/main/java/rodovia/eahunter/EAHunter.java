package rodovia.eahunter;

import javax.security.auth.login.LoginException;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import rodovia.eahunter.command.CommandManager;
import rodovia.eahunter.commands.UserInfoCommand;

public class EAHunter {
	private static JDA jda;
	private static CommandManager cmdman;
	
	public static JDA asJDA() {
		return jda;
	}
	
	public static String prefix() {
		return System.getProperty("PREFIX");
	}
	
	public static CommandManager commandManager() {
		return cmdman;
	}
	
	public static void main(String[] args) throws LoginException {
		Dotenv
			.configure()
			.systemProperties()
			.load();
		
		cmdman = new CommandManager();
		cmdman.addCommandMany(
			new UserInfoCommand()
		);
		
		jda = JDABuilder.createLight(System.getProperty("TOKEN"))
				.setStatus(OnlineStatus.DO_NOT_DISTURB)
				.addEventListeners(new EventListener())
				.build();		
	}
}
