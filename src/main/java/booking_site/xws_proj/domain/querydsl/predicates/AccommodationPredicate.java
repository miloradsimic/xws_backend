package booking_site.xws_proj.domain.querydsl.predicates;

import com.querydsl.core.types.Predicate;

import booking_site.xws_proj.domain.querydsl.QReservation;

public class AccommodationPredicate {

	public AccommodationPredicate() {
	}

	public static Predicate reservationsForAccommodation(Long id) {
		return QReservation.reservation.accommodation.id.eq(id);
	}

	public static Predicate reservationsForUser(Long userId) {
		return QReservation.reservation.client.id.eq(userId);
	}

}
