package booking_site.xws_proj.controller;

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
import booking_site.xws_proj.domain.dto.request.UserRegisterRequestDTO;
import booking_site.xws_proj.domain.dto.response.ErrorResponse;
import booking_site.xws_proj.domain.dto.response.UserResponseDTO;
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

	/*
	 * Create
	 * 
	 * @return UserResponseDTO or ErrorResponse object
	 */
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody UserRegisterRequestDTO userDto, HttpServletResponse response) {
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
	 * Read one
	 */
	@RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserResponseDTO> readOne(@PathVariable("id") Long id) {
		// TODO M: Use predicate to exclude passwords
		return new ResponseEntity<UserResponseDTO>(UserMapper.mapEntityIntoDTO(userService.findUser(id)),
				HttpStatus.OK);
	}

	/*
	 * Read all
	 */
	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> readAll() {
		// TODO M: Use predicate to exclude passwords
		return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
	}

	/*
	 * Update
	 * 
	 * @return UserResponseDTO or ErrorResponse object
	 */
	@RequestMapping(path = "/user", method = RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestHeader("Authorization") String encoded, @RequestBody User userDTO) {
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
		} // else permission granted

		userService.updateUser(userDTO);

		return new ResponseEntity<Object>(UserMapper.mapEntityIntoDTO(userRepository.findOne(user.getId())),
				HttpStatus.OK);

	}

	/*
	 * Delete
	 * 
	 * @return Nothing or ErrorResponse object
	 */
	@RequestMapping(path = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@RequestHeader("Authorization") String encoded,
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
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNAUTHORIZED);

		} // else permission granted

		userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	/*
	 * Block or Activate
	 * 
	 * @param action: true for block user; false for activate user
	 * 
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
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNAUTHORIZED);

		} // else permission granted

		if (!userService.blockUser(userId, action)) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setError("User doesn't exit.");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
