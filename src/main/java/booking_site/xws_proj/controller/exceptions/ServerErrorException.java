package booking_site.xws_proj.controller.exceptions;

public class ServerErrorException extends RuntimeException {

	public ServerErrorException() {
		super("Oops! Something went wrong on the server");
	}

	public ServerErrorException(String message) {
		super(message);
	}


	 
}
