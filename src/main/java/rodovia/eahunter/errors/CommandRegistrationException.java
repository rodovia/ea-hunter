package rodovia.eahunter.errors;

public class CommandRegistrationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CommandRegistrationException() {
		super();
	}
	
	public CommandRegistrationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CommandRegistrationException(String message) {
		super(message);
	}
}
