package booking_site.xws_proj.service;

import java.util.List;

import booking_site.xws_proj.domain.User;
import booking_site.xws_proj.domain.AUser;

//TODO M: Pogledaj opet ovaj intefejs ako treba sta menjati
public interface IUserService {

	
	//Ovo verovatno moze direktno iz repositorija, ali da bi napravili restrikcije trebamo redefinisati
	//crud
	boolean createUser(User user);
	User findUser(long id);
	boolean updateUser(User user);
	void deleteUser(long id);
	
	//ostalo
	List<User> findAll();
	boolean blockUser(long id);
	
	
}
