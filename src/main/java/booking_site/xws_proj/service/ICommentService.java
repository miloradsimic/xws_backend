package booking_site.xws_proj.service;

import java.util.List;

import booking_site.xws_proj.controller.exceptions.AllreadyCommentedThisAccommodationException;
import booking_site.xws_proj.controller.exceptions.NeverReservedException;
import booking_site.xws_proj.domain.Comment;
import booking_site.xws_proj.domain.enums.Status;

public interface ICommentService {
	// crud
	Comment createComment(Comment comment) throws AllreadyCommentedThisAccommodationException, NeverReservedException;

	void deleteComment(long id);

	// ostalo
	Boolean changeStatus(long id, Status status);

	List<Comment> findAllNotReviewed();

	List<Comment> findAllForAccommodation(long id);
}
