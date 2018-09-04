package booking_site.xws_proj.domain.querydsl.predicates;

import com.querydsl.core.types.Predicate;

import booking_site.xws_proj.domain.enums.Status;
import booking_site.xws_proj.domain.querydsl.QComment;

public class CommentPredicate {

	public static Predicate findExisting(long user_id, long accommodation_id) {
		return QComment.comment.user.id.eq(user_id).and(QComment.comment.accommodation.id.eq(accommodation_id));
	}

	public static Predicate findAllWaitingForApproval() {
		return QComment.comment.approvalState.eq(Status.WAITING_FOR_APPROVAL);
	}

	public static Predicate findAllForAccommodation(long id) {
		return QComment.comment.accommodation.id.eq(id).and(QComment.comment.approvalState.eq(Status.APPROVED));
	}
}
