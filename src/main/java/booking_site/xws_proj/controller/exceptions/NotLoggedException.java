package booking_site.xws_proj.controller.exceptions;

public class NotLoggedException extends RuntimeException {

	public NotLoggedException() {
		super("You have to log in.");
	}

	public NotLoggedException(String message) {
		super(message);
	}
	
	
}
