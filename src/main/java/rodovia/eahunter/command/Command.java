package rodovia.eahunter.command;

public abstract class Command {
	
	protected String name = null;
	protected String[] aliases = new String[0];
	
	protected abstract void execute(Context ctx, String[] args);
	
	public final String getName() {
		return name;
	}
	
	public final String[] getAliases() {
		return aliases;
	}
	
	public void run(Context ctx) {
		execute(ctx, new String[0]);
	}
	
	public void run(Context ctx, String[] args) {
		execute(ctx, args);
	}
	
}
