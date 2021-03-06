package booking_site.xws_proj.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import booking_site.xws_proj.AppUtils;
import booking_site.xws_proj.controller.exceptions.AlreadyExistsException;
import booking_site.xws_proj.controller.exceptions.NotAuthorizedException;
import booking_site.xws_proj.controller.exceptions.NotFoundException;
import booking_site.xws_proj.controller.exceptions.NotLoggedException;
import booking_site.xws_proj.domain.AUser;
import booking_site.xws_proj.domain.User;
import booking_site.xws_proj.domain.dto.mappper.UserMapper;
import booking_site.xws_proj.domain.dto.request.UserRegisterRequestDTO;
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
	 * @return UserResponseDTO
	 */
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ResponseEntity<UserResponseDTO> create(@RequestBody UserRegisterRequestDTO userDto,
			HttpServletResponse response) {
		User user;
		if ((user = userService.createUser(new User(userDto))) == null) {
			throw new AlreadyExistsException();
		}
		response.setHeader("Authorization", AppUtils.encryptBasic(user.getEmail(), user.getPassword()));
		return new ResponseEntity<UserResponseDTO>(UserMapper.mapEntityIntoDTO(user), HttpStatus.CREATED);
	}

	/*
	 * Read one
	 */
	@RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserResponseDTO> readOne(@PathVariable("id") Long id) {
		return new ResponseEntity<UserResponseDTO>(UserMapper.mapEntityIntoDTO(userService.findUser(id)),
				HttpStatus.OK);
	}

	/*
	 * Read all
	 */
	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<UserResponseDTO>> readAll() {
		List<UserResponseDTO> list = new ArrayList<UserResponseDTO>();
		userService.findAll().forEach(e -> list.add(UserMapper.mapEntityIntoDTO(e)));
		return new ResponseEntity<List<UserResponseDTO>>(list, HttpStatus.OK);
	}

	/*
	 * Update
	 * 
	 * @return UserResponseDTO
	 */
	@RequestMapping(path = "/user", method = RequestMethod.PUT)
	public ResponseEntity<UserResponseDTO> update(HttpServletRequest request, @RequestBody User userDTO) {
		User user;

		String encoded = request.getHeader("Authorization");
		String username = AppUtils.getUsernameFromBasic(encoded);
		String password = AppUtils.getPasswordFromBasic(encoded);
		if ((user = userRepository.findByEmailAndPassword(username, password)) == null) {
			throw new NotLoggedException();
		}
		if (!user.getEmail().equalsIgnoreCase(userDTO.getEmail())) {
			throw new NotAuthorizedException();
		}
		if (user.isActive() != userDTO.isActive() || user.isDeleted() != userDTO.isDeleted()
				|| userDTO.getRole() != Role.USER) {
			throw new NotFoundException();
		} // else permission granted

		userService.updateUser(userDTO);

		return new ResponseEntity<UserResponseDTO>(UserMapper.mapEntityIntoDTO(userRepository.findOne(user.getId())),
				HttpStatus.OK);

	}

	/*
	 * Delete
	 * 
	 */
	@RequestMapping(path = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(HttpServletRequest request, @PathVariable("id") Long userId) {
		AUser admin;

		String encoded = request.getHeader("Authorization");
		String username = AppUtils.getUsernameFromBasic(encoded);
		String password = AppUtils.getPasswordFromBasic(encoded);
		if ((admin = aUserRepository.findByEmailAndPassword(username, password)) == null) {
			throw new NotLoggedException();
		}
		if (admin.getRole() != Role.ADMIN) {
			throw new NotAuthorizedException();
		} // else permission granted

		userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	/*
	 * Block or Activate
	 * 
	 * @param action: true for block user; false for activate user
	 * 
	 */
	@RequestMapping(path = "/user/{id}/{action}", method = RequestMethod.PUT)
	public ResponseEntity<Void> blockUser(HttpServletRequest request, @PathVariable("id") Long userId,
			@PathVariable Boolean action) {
		AUser admin;

		String encoded = request.getHeader("Authorization");
		String username = AppUtils.getUsernameFromBasic(encoded);
		String password = AppUtils.getPasswordFromBasic(encoded);
		if ((admin = aUserRepository.findByEmailAndPassword(username, password)) == null) {
			throw new NotLoggedException();
		}
		if (admin.getRole() != Role.ADMIN) {
			throw new NotAuthorizedException();
		} // else permission granted

		if (!userService.blockUser(userId, action)) {
			throw new NotFoundException();
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
