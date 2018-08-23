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
import booking_site.xws_proj.domain.dto.mappper.UserMapper;
import booking_site.xws_proj.domain.dto.request.UserLoginRequestDTO;
import booking_site.xws_proj.domain.dto.response.ErrorResponse;
import booking_site.xws_proj.domain.dto.response.UserResponseDTO;
import booking_site.xws_proj.repository.AUserRepository;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private AUserRepository repository;

	/*
	 * @return UserResponseDTO or ErrorResponse object
	 */
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ResponseEntity<Object> tryToLogin(@RequestBody UserLoginRequestDTO user, HttpServletResponse response) {
		UserResponseDTO userResponse = UserMapper
				.mapEntityIntoDTO(repository.findByEmailAndPassword(user.getEmail(), user.getPassword()));

		if (userResponse == null) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setError("Wrong credentials.");
			return new ResponseEntity<Object>(userResponse, HttpStatus.UNAUTHORIZED);
		}

		response.setHeader("Authorization", AppUtils.encryptBasic(user.getEmail(), user.getPassword()));
		return new ResponseEntity<Object>(userResponse, HttpStatus.OK);

	}

	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public ResponseEntity<Void> logout(HttpServletResponse response) {
		response.setHeader("Authorization", "");
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
