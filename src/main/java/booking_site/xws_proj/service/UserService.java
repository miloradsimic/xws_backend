package booking_site.xws_proj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import booking_site.xws_proj.domain.User;
import booking_site.xws_proj.repository.UserRepository;

@Service
public class UserService implements IUserService {
	

	@Autowired
	private UserRepository userRepository;

	//crud metode
	@Override
	public boolean createUser(User user) {
		if(userRepository.findByEmail(user.getEmail()) != null) {
			return false;
		}
		userRepository.save(user);
		return true;
	}

	@Override
	public User findUser(long id) {
		return userRepository.findOne(id);
	}

	@Override
	public boolean updateUser(User user) {
		if(userRepository.exists(user.getId())) {
			userRepository.save(user);
			return true;
		}
		return false;
	}

	@Override
	public void deleteUser(long id) {
		if(userRepository.exists(id)) {
			User user = userRepository.findOne(id);
			user.setDeleted(true);
			userRepository.save(user);
		}
	}
	//ostalo
	@Override
	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public boolean blockUser(long id, boolean action) {
		if(userRepository.exists(id)) {
			User user = userRepository.findOne(id);
			user.setActive(action);
			userRepository.save(user);
			return true;
		}
		return false;
	}

		
}

























