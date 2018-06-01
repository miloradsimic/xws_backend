package booking_site.xws_proj.repository.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import booking_site.xws_proj.domain.User;
import booking_site.xws_proj.repository.UserRepository;
import booking_site.xws_proj.service.UserService;

@Service
public class RepositoryUserService implements UserService {
	

	@Autowired
	private UserRepository userRepository;

	@Override
	public Collection<User> findAll() {
		
		return Lists.newArrayList(userRepository.findAll());
	}

	@Override
	public Collection<User> findUsers(String name) {
		// TODO Auto-generated method stub
		return null;
	}


}
