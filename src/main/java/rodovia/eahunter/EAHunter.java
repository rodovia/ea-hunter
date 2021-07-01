package rodovia.eahunter;

import javax.security.auth.login.LoginException;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;

public class EAHunter {
	private static JDA jda;
	
	public static JDA asJDA() {
		return jda;
	}
	
	public static void main(String[] args) throws LoginException {
		Dotenv
			.configure()
			.systemProperties()
			.load();
		
		jda = JDABuilder.createLight(System.getProperty("TOKEN"))
				.setStatus(OnlineStatus.DO_NOT_DISTURB)
				.addEventListeners(new EventListener())
				.build();
	}
}
