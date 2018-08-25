package booking_site.xws_proj.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import booking_site.xws_proj.AppUtils;
import booking_site.xws_proj.controller.exceptions.LoginFailedException;
import booking_site.xws_proj.domain.dto.mappper.UserMapper;
import booking_site.xws_proj.domain.dto.request.UserLoginRequestDTO;
import booking_site.xws_proj.domain.dto.response.UserResponseDTO;
import booking_site.xws_proj.domain.enums.Role;
import booking_site.xws_proj.repository.AUserRepository;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private AUserRepository repository;

	/*
	 * Login for User
	 * 
	 * @return UserResponseDTO
	 */
	@RequestMapping(path = "/user_login", method = RequestMethod.POST)
	public ResponseEntity<UserResponseDTO> userLogin(@RequestBody UserLoginRequestDTO user,
			HttpServletResponse response) {
		UserResponseDTO userResponse = UserMapper
				.mapEntityIntoDTO(repository.findByEmailAndPassword(user.getEmail(), user.getPassword()));
		if (userResponse == null || repository.findOne(userResponse.getId()).getRole() != Role.USER) {
			throw new LoginFailedException();
		}

		response.setHeader("Authorization", AppUtils.encryptBasic(user.getEmail(), user.getPassword()));
		return new ResponseEntity<UserResponseDTO>(userResponse, HttpStatus.OK);

	}

	/*
	 * Login for Agent
	 * 
	 * @return UserResponseDTO
	 */
	@RequestMapping(path = "/agent_login", method = RequestMethod.POST)
	public ResponseEntity<UserResponseDTO> agentLogin(@RequestBody UserLoginRequestDTO user,
			HttpServletResponse response) {
		UserResponseDTO userResponse = UserMapper
				.mapEntityIntoDTO(repository.findByEmailAndPassword(user.getEmail(), user.getPassword()));
		if (userResponse == null || repository.findOne(userResponse.getId()).getRole() != Role.AGENT) {
			throw new LoginFailedException();
		}

		response.setHeader("Authorization", AppUtils.encryptBasic(user.getEmail(), user.getPassword()));
		return new ResponseEntity<UserResponseDTO>(userResponse, HttpStatus.OK);

	}

	/*
	 * Login for Admin
	 * 
	 * @return UserResponseDTO
	 */
	@RequestMapping(path = "/admin_login", method = RequestMethod.POST)
	public ResponseEntity<UserResponseDTO> adminLogin(@RequestBody UserLoginRequestDTO user,
			HttpServletResponse response) {
		UserResponseDTO userResponse = UserMapper
				.mapEntityIntoDTO(repository.findByEmailAndPassword(user.getEmail(), user.getPassword()));
		if (userResponse == null || repository.findOne(userResponse.getId()).getRole() != Role.AGENT) {
			throw new LoginFailedException();
		}

		response.setHeader("Authorization", AppUtils.encryptBasic(user.getEmail(), user.getPassword()));
		return new ResponseEntity<UserResponseDTO>(userResponse, HttpStatus.OK);

	}

	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public ResponseEntity<Void> logout(HttpServletResponse response) {
		response.setHeader("Authorization", "");
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
