package rodovia.eahunter.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import rodovia.eahunter.command.Context;

public class ArgumentParser {
	private static final Pattern MENTION = Pattern.compile("^<@!?(\\d{17,19})>");
	private static final Pattern BROKEN_MENTION = Pattern.compile("^@(\\S.{0,30}\\S)#(\\d{4})");
	private static final Pattern ID = Pattern.compile("^(\\d{17,19})");
	
	private ArgumentParser() {
		
	}
	
	public static Arguments parseMentions(Context ctx, String[] args) {
		Matcher mat;
		List<Member> members = new ArrayList<>();
		List<Long> ids = new ArrayList<>();
		List<User> users = new ArrayList<>();
		
		for (String arg : args) {
			mat = MENTION.matcher(arg);
			
			if (mat.find()) {
				long id = Long.parseLong(mat.group(1));
				User wrl = ctx.getClient().getUserById(id);
				
				if (wrl == null)
					ids.add(id);
				else if (ctx.getGuild().isMember(wrl))
					members.add(ctx.getGuild().getMember(wrl));
				else 
					users.add(wrl);
			}
			
			mat = BROKEN_MENTION.matcher(arg);
			if (mat.find()) {
				for (User user : ctx.getClient().getUserCache().asList()) {
					if 	(	user.getName().equals(mat.group(1)) && 
							user.getDiscriminator().equals(mat.group(2))) {
						
						if (ctx.getGuild().isMember(user))
							members.add(ctx.getGuild().getMember(user));
						else
							users.add(user);
					}
				}
			}
			
			mat = ID.matcher(arg);
			if (mat.find()) {
				User us = ctx.getClient().getUserById(mat.group(1));
				
				if (us == null)
					ids.add(Long.parseLong(mat.group(1)));
				else if (ctx.getGuild().isMember(us))
					members.add(ctx.getGuild().getMember(us));
				else
					users.add(us);
			}
		}
		
		return new Arguments(users, members, ids);
	}

}
