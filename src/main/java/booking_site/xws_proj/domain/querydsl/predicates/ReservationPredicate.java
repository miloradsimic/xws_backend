package booking_site.xws_proj.domain.querydsl.predicates;

import com.querydsl.core.types.Predicate;

import booking_site.xws_proj.domain.enums.Status;
import booking_site.xws_proj.domain.querydsl.QReservation;

public class ReservationPredicate {

	public static Predicate hasApprovedReservation(Long user, Long accommodation) {
		return QReservation.reservation.clientId.eq(user)
				.and(QReservation.reservation.accommodationId.eq(accommodation))
				.and(QReservation.reservation.status.eq(Status.APPROVED));
	}
}
