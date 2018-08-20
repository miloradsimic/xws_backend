package booking_site.xws_proj.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import booking_site.xws_proj.domain.User;

public interface UserRepository extends CrudRepository<User, Long>, QueryDslPredicateExecutor<User> {

	Iterable<User> findAll();

	// Find all users with selected name
	public User findByNameAllIgnoringCase(String name);

	public User findByEmailAndPassword(String email, String password);

	User findByEmail(String email);

}
