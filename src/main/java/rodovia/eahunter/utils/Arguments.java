package rodovia.eahunter.utils;

import java.util.List;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;

public class Arguments {
	private List<User> users;
	private List<Member> members;
	private List<Long> ids;
	
	public Arguments(List<User> users, List<Member> members, List<Long> ids) {
		this.users = users;
		this.members = members;
		this.ids = ids;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public List<Member> getMembers() {
		return members;
	}
	
	public List<Long> getIds() {
		return ids;
	}
}
