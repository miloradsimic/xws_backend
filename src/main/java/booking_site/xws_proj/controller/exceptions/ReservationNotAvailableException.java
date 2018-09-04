package booking_site.xws_proj.controller.exceptions;

public class ReservationNotAvailableException extends RuntimeException {
	public ReservationNotAvailableException() {
		super("It's not possible to reserve accommodation for that interval.");
	}

	public ReservationNotAvailableException(String message) {
		super(message);
	}

	

}
