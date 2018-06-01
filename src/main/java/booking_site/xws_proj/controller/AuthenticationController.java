package booking_site.xws_proj.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import booking_site.xws_proj.AppUtils;
import booking_site.xws_proj.dto.mapper.UserMapper;
import booking_site.xws_proj.dto.response.UserResponseDTO;
import booking_site.xws_proj.repository.UserRepository;
import booking_site.xws_proj.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
    private UserRepository repository;

	@Autowired
	private UserService service;
	
	@RequestMapping(path="/login", method = RequestMethod.POST)
	public UserResponseDTO tryToLogin(@RequestHeader("Authorization") String encoded) {
		
		String username = AppUtils.getUsernameFromBasic(encoded);
		String password = AppUtils.getPasswordFromBasic(encoded);

		return UserMapper.mapEntityIntoDTO(this.service.findByEmailAndPasswordLogin(username, password));
	}
	

	
	@RequestMapping(path="/logout", method = RequestMethod.GET)
	public boolean tryToLogin(HttpSession httpSession) {
		httpSession.setAttribute("user", null);
		return true;
	}
}
