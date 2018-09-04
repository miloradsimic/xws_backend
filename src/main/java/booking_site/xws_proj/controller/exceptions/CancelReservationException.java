package booking_site.xws_proj.controller.exceptions;

public class CancelReservationException extends RuntimeException {

	public CancelReservationException() {
		super("Unable to cancel reservation because reservation already started.");
	}

	public CancelReservationException(String message) {
		super(message);
	}

}
