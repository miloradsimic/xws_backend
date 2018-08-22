package booking_site.xws_proj.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import booking_site.xws_proj.domain.Admin;

public interface AdminRepository extends CrudRepository<Admin, Long>, QueryDslPredicateExecutor<Admin> {

	// for login mainly
	public Admin findByEmailAndPassword(String email, String password);

}
