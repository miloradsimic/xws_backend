package booking_site.xws_proj.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import booking_site.xws_proj.AppUtils;
import booking_site.xws_proj.dto.mapper.UserMapper;
import booking_site.xws_proj.dto.request.UserLoginRequestDTO;
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
	public HashMap<String, Object> tryToLogin(@RequestBody UserLoginRequestDTO user, HttpServletResponse response) {
		HashMap<String, Object> retVal = new HashMap<>();
		UserResponseDTO userResponse = UserMapper.mapEntityIntoDTO(this.service.findByEmailAndPasswordLogin(user.email, user.password));
		
		if(userResponse == null) {
			retVal.put("message", "The email or the password you've entered is incorrect");
			return retVal;
		}
		retVal.put("message", "OK");
		retVal.put("data", userResponse);
		
		response.setHeader("Authorization", AppUtils.encryptBasic(user));
		
		
		return retVal;
	}
	

	
	@RequestMapping(path="/logout", method = RequestMethod.GET)
	public boolean tryToLogin(HttpSession httpSession) {
		httpSession.setAttribute("user", null);
		return true;
	}
}
