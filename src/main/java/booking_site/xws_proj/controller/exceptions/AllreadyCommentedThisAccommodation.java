package booking_site.xws_proj.controller.exceptions;

public class AllreadyCommentedThisAccommodation extends RuntimeException {
	
	public AllreadyCommentedThisAccommodation() {
		super("You already have one comment for this accommodation.");
	}

	public AllreadyCommentedThisAccommodation(String message) {
		super(message);
	}

}
