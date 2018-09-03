package booking_site.xws_proj.domain.querydsl.predicates;

import java.util.Date;

import com.querydsl.core.types.Predicate;

import booking_site.xws_proj.domain.AClient;
import booking_site.xws_proj.domain.Accommodation;
import booking_site.xws_proj.domain.enums.Status;
import booking_site.xws_proj.domain.querydsl.QReservation;

public class ReservationPredicate {

	// If user have approved reservation, he can comment on selected accommodation
	public static Predicate hasApprovedReservation(AClient user, Accommodation accommodation) {
		return QReservation.reservation.client.eq(user)
				.and(QReservation.reservation.accommodation.eq(accommodation))
				.and(QReservation.reservation.status.eq(Status.APPROVED));
	}

	public static Predicate findReserved(Date from, Date to) {
		return QReservation.reservation.endTime.before(to)
				.and(QReservation.reservation.endTime.after(from))
				.or(QReservation.reservation.startTime.after(from))
				.and(QReservation.reservation.startTime.before(to));
	}

	public static Predicate findReserved(Date from, Date to, Long id) {
		System.out.println(from  + "   " + to  + "    " + id );
		return QReservation.reservation.endTime.before(to)
				.and(QReservation.reservation.endTime.after(from))
				.or(QReservation.reservation.startTime.after(from))
				.and(QReservation.reservation.startTime.before(to))
				.and(QReservation.reservation.accommodation.id.eq(id));
	}
}
