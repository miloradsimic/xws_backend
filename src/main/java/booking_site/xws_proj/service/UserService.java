package booking_site.xws_proj.service;

import java.util.Collection;

import booking_site.xws_proj.domain.User;

public interface UserService {


	Collection<User> findAll();	
	Collection<User> findUsers(String name);
}
