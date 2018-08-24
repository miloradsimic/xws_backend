package booking_site.xws_proj.controller.exceptions;

public class AlreadyExistsException extends RuntimeException {

	public AlreadyExistsException() {
		super("Object with same ID already exist.");
	}

	public AlreadyExistsException(String message) {
		super(message);
	}
	
	

}
