package booking_site.xws_proj.controller.exceptions;

public class NotAuthorizedException extends RuntimeException {

	public NotAuthorizedException() {
		super("Not enough permissions.");
	}

	public NotAuthorizedException(String message) {
		super(message);
	}

}
