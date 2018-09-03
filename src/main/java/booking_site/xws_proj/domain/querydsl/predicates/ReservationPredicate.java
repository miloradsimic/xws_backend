package booking_site.xws_proj.domain.querydsl.predicates;

import com.querydsl.core.types.Predicate;

import booking_site.xws_proj.domain.AClient;
import booking_site.xws_proj.domain.Accommodation;
import booking_site.xws_proj.domain.QReservation;
import booking_site.xws_proj.domain.enums.Status;

public class ReservationPredicate {

	// If user have approved reservation, he can comment on selected accommodation
	public static Predicate hasApprovedReservation(AClient user, Accommodation accommodation) {
		return QReservation.reservation.client.eq(user)
				.and(QReservation.reservation.accommodation.eq(accommodation))
				.and(QReservation.reservation.status.eq(Status.APPROVED));
	}
}
