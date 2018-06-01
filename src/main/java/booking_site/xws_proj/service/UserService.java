package booking_site.xws_proj.service;

import java.util.Collection;

import booking_site.xws_proj.domain.User;

public interface UserService {


	Collection<User> findAll();	
	User findByEmailAndPasswordLogin(String email, String password);
}
