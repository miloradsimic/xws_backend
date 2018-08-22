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
import booking_site.xws_proj.domain.dto.response.UserResponseDTO;
import booking_site.xws_proj.repository.AUserRepository;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private AUserRepository repository;

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ResponseEntity<UserResponseDTO> tryToLogin(@RequestBody UserLoginRequestDTO user,
			HttpServletResponse response) {
		UserResponseDTO userResponse = UserMapper
				.mapEntityIntoDTO(repository.findByEmailAndPassword(user.email, user.password));

		if (userResponse == null) {
			userResponse = new UserResponseDTO();
			userResponse.setErrorMessage("Wrong credentials.");
			return new ResponseEntity<UserResponseDTO>(userResponse, HttpStatus.UNAUTHORIZED);
		}

		response.setHeader("Authorization", AppUtils.encryptBasic(user.email, user.password));
		return new ResponseEntity<UserResponseDTO>(userResponse, HttpStatus.OK);

	}

	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public ResponseEntity<Void> logout(HttpServletResponse response) {
		response.setHeader("Authorization", "");
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
