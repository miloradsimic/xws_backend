package booking_site.xws_proj.controller.exceptions;

public class NeverReservedException extends RuntimeException {

	public NeverReservedException() {
		super("You haven't stayed in this accommodation. You can't comment.");
	}

	public NeverReservedException(String message) {
		super(message);
	}
}
