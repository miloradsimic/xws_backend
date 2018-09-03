package booking_site.xws_proj.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import booking_site.xws_proj.domain.Reservation;
import booking_site.xws_proj.domain.User;

public interface ReservationRepository extends CrudRepository<Reservation, Long>, QueryDslPredicateExecutor<Reservation> {

	Iterable<Reservation> findAll();

	
}
