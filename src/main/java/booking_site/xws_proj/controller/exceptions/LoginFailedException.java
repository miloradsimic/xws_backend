package booking_site.xws_proj.controller.exceptions;

public class LoginFailedException extends RuntimeException {

	public LoginFailedException() {
		super("Wrong credentials.");
	}

	public LoginFailedException(String message) {
		super(message);
	}

}
