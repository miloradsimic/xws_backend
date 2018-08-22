package booking_site.xws_proj.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import booking_site.xws_proj.AppUtils;
import booking_site.xws_proj.domain.AUser;
import booking_site.xws_proj.domain.User;
import booking_site.xws_proj.domain.dto.mappper.UserMapper;
import booking_site.xws_proj.domain.dto.request.ReservationDTO;
import booking_site.xws_proj.domain.dto.request.UserRegisterRequestDTO;
import booking_site.xws_proj.domain.dto.response.ErrorResponse;
import booking_site.xws_proj.domain.dto.response.ReservationResponseDTO;
import booking_site.xws_proj.domain.enums.Role;
import booking_site.xws_proj.repository.AUserRepository;
import booking_site.xws_proj.repository.UserRepository;
import booking_site.xws_proj.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private AUserRepository aUserRepository;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> readUsers() {
		return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
	}

	/*
	 * @return UserResponseDTO or ErrorResponse object
	 */
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ResponseEntity<Object> createUser(@RequestBody UserRegisterRequestDTO userDto,
			HttpServletResponse response) {
		User user;
		if ((user = userService.createUser(new User(userDto))) == null) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setError("The email is already registered. Try another one!");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.CONFLICT);
		}
		response.setHeader("Authorization", AppUtils.encryptBasic(user.getEmail(), user.getPassword()));
		return new ResponseEntity<Object>(UserMapper.mapEntityIntoDTO(user), HttpStatus.CREATED);
	}

	/*
	 * @return ReservationResponseDTO or ErrorResponse object
	 */
	@RequestMapping(path = "/reservation", method = RequestMethod.POST)
	public ResponseEntity<Object> makeAReservatiosn(@RequestHeader("Authorization") String encoded,
			@RequestBody ReservationDTO reservationDTO) {
		ReservationResponseDTO reservationResponse;
		User user;

		String username = AppUtils.getUsernameFromBasic(encoded);
		String password = AppUtils.getPasswordFromBasic(encoded);
		if ((user = userRepository.findByEmailAndPassword(username, password)) == null) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setError("You have to be logged to make a reservation.");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNAUTHORIZED);

		} // else successful login

		// TODO: Unimplemented!!! check if user is reserving for himself
		// try to reserve, receive feedback message or error, forward to client
		// through retVal
		reservationResponse = new ReservationResponseDTO();
		reservationResponse.setUser_email("email@email.com");
		reservationResponse.setId(1000);
		reservationResponse.setAgent_email("email@email.com2");
		reservationResponse.setStart_time(new Date());
		reservationResponse.setEnd_time(new Date());
		return new ResponseEntity<Object>(reservationResponse, HttpStatus.OK);

	}

	/*
	 * @return Nothing or ErrorResponse object
	 */
	@RequestMapping(path = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteUser(@RequestHeader("Authorization") String encoded,
			@PathVariable("id") Long userId) {
		AUser admin;

		String username = AppUtils.getUsernameFromBasic(encoded);
		String password = AppUtils.getPasswordFromBasic(encoded);
		if ((admin = aUserRepository.findByEmailAndPassword(username, password)) == null) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setError("You have to be logged to delete user.");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNAUTHORIZED);

		}
		if (admin.getRole() != Role.ADMIN) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setError("Only admins have privs to delete users.");
			// Ili FORBIDEN ili nesto drugo??
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNAUTHORIZED);

		} // else successful login

		userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	/*
	 * @return UserResponseDTO or ErrorResponse object
	 */
	@RequestMapping(path = "/user", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateUser(@RequestHeader("Authorization") String encoded,
			@RequestBody User userDTO) {
		User user;

		String username = AppUtils.getUsernameFromBasic(encoded);
		String password = AppUtils.getPasswordFromBasic(encoded);
		if ((user = userRepository.findByEmailAndPassword(username, password)) == null) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setError("You have to be logged to update user.");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNAUTHORIZED);

		}
		if (!user.getEmail().equalsIgnoreCase(userDTO.getEmail())) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setError("You can update only your account.");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNAUTHORIZED);

		}
		if (user.isActive() != userDTO.isActive() || user.isDeleted() != userDTO.isDeleted()
				|| userDTO.getRole() != Role.USER) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setError("Only admins can delete and block users.");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNAUTHORIZED);
		} // else successful login

		userDTO.setId(user.getId());
		userService.updateUser(userDTO);

		return new ResponseEntity<Object>(UserMapper.mapEntityIntoDTO(userRepository.findOne(user.getId())),
				HttpStatus.OK);

	}

	/*
	 * @return Nothing or ErrorResponse object
	 */
	@RequestMapping(path = "/user/{id}/{action}", method = RequestMethod.PUT)
	public ResponseEntity<Object> blockUser(@RequestHeader("Authorization") String encoded,
			@PathVariable("id") Long userId, @PathVariable Boolean action) {
		AUser admin;

		String username = AppUtils.getUsernameFromBasic(encoded);
		String password = AppUtils.getPasswordFromBasic(encoded);
		if ((admin = aUserRepository.findByEmailAndPassword(username, password)) == null) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setError("You have to be logged to manage users.");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNAUTHORIZED);

		}
		if (admin.getRole() != Role.ADMIN) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setError("Only admins have privs to manage users.");
			// Ili FROBIDEN ili nesto drugo??
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNAUTHORIZED);

		} // else successful login

		if (!userService.blockUser(userId, action)) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setError("User doesn't exit.");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
