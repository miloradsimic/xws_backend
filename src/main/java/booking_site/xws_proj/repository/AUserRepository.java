package booking_site.xws_proj.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import booking_site.xws_proj.domain.AUser;
import booking_site.xws_proj.domain.Agent;

public interface AUserRepository extends CrudRepository<AUser, Long>, QueryDslPredicateExecutor<AUser> {

	// for login mainly
	public AUser findByEmailAndPassword(String email, String password);

	public Agent save(Agent agent);

}
