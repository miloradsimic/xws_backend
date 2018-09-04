package booking_site.xws_proj.controller.exceptions;

public class DateQueryException extends RuntimeException {

	public DateQueryException() {
		super("Invalid date query. FROM is after TO");
	}

	public DateQueryException(String message) {
		super(message);
	}

}
