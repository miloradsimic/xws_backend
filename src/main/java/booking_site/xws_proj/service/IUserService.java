package booking_site.xws_proj.service;

import java.util.List;

import booking_site.xws_proj.domain.User;

//TODO M: Pogledaj opet ovaj intefejs ako treba sta menjati
public interface IUserService {

	// crud
	User createUser(User user);

	User findUser(long id);

	boolean updateUser(User user);

	void deleteUser(long id);

	// ostalo
	List<User> findAll();

	boolean blockUser(long id, boolean action);

}
