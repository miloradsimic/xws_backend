package booking_site.xws_proj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;

import booking_site.xws_proj.controller.exceptions.AllreadyCommentedThisAccommodationException;
import booking_site.xws_proj.controller.exceptions.NeverReservedException;
import booking_site.xws_proj.domain.Comment;
import booking_site.xws_proj.domain.Reservation;
import booking_site.xws_proj.domain.dto.response.ReservationResponseDTO;
import booking_site.xws_proj.domain.enums.Status;
import booking_site.xws_proj.domain.querydsl.predicates.CommentPredicate;
import booking_site.xws_proj.domain.querydsl.predicates.ReservationPredicate;
import booking_site.xws_proj.repository.CommentRepository;
import booking_site.xws_proj.repository.ReservationRepository;

@Service
public class CommentService implements ICommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Override
	public Comment createComment(Comment comment) {
		Predicate pred = CommentPredicate.findExisting(comment.getUser().getId(), comment.getAccommodation().getId());
		if (commentRepository.findAll(pred).iterator().hasNext()) {
			throw new AllreadyCommentedThisAccommodationException();
		} // Hasn't commented earlier on current accommodation
		Predicate pred2 = ReservationPredicate.hasApprovedReservation(comment.getUser(), comment.getAccommodation());

		if (!reservationRepository.findAll(pred2).iterator().hasNext()) {
			throw new NeverReservedException();
		} // Hasn't reserved accommodation EVER!
		return commentRepository.save(comment);
	}

	@Override
	public void deleteComment(long id) {
		commentRepository.delete(id);
	}

	@Override
	public Boolean changeStatus(long id, Status status) {
		if (commentRepository.exists(id)) {
			if (status == Status.DISAPPROVED) {
				deleteComment(id);
				return true;
			}
			Comment entry = commentRepository.findOne(id);
			entry.setApprovalState(status);
			if (commentRepository.save(entry) != null) {
				return true;
			}

		}
		return false;
	}

	@Override
	public List<Comment> findAllNotReviewed() {
		Predicate pred = CommentPredicate.findAllWaitingForApproval();
		List<Comment> list = new ArrayList<>();
		commentRepository.findAll(pred).forEach(e -> list.add(e));
		return list;
	}

	@Override
	public List<Comment> findAllForAccommodation(long id) {
		Predicate pred = CommentPredicate.findAllForAccommodation(id);
		List<Comment> list = new ArrayList<>();
		commentRepository.findAll(pred).forEach(e -> list.add(e));
		return list;
	}

}
