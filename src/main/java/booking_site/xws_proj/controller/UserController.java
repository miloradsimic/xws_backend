package booking_site.xws_proj.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import booking_site.xws_proj.domain.User;
import booking_site.xws_proj.dto.response.UserResponseDTO;
import booking_site.xws_proj.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/users", method = RequestMethod.GET)
	Collection<UserResponseDTO> readUsers() {

		Collection<User> collectionA = this.userService.findAll();
		
		Collection<UserResponseDTO> collectionDTO = collectionA.stream()
                .map(UserResponseDTO::new)
                .collect(Collectors.toList());
		return collectionDTO;
	}

}
