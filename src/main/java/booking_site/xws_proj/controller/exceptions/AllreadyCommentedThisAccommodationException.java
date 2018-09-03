package booking_site.xws_proj.controller.exceptions;

public class AllreadyCommentedThisAccommodationException extends RuntimeException {
	
	public AllreadyCommentedThisAccommodationException() {
		super("You already have one comment for this accommodation.");
	}

	public AllreadyCommentedThisAccommodationException(String message) {
		super(message);
	}

}
