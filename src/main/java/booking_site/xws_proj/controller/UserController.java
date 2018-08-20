package booking_site.xws_proj.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

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
import booking_site.xws_proj.domain.dto.response.ReservationResponseDTO;
import booking_site.xws_proj.domain.dto.response.ResponseErrorHandler;
import booking_site.xws_proj.domain.dto.response.UserResponseDTO;
import booking_site.xws_proj.domain.enums.Role;
import booking_site.xws_proj.repository.AUserRepository;
import booking_site.xws_proj.repository.AdminRepository;
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

	@Autowired
	private AdminRepository adminRepository;

	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> readUsers() {
		return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
	}

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRegisterRequestDTO userDto,
			HttpServletResponse response) {
		User user = new User(userDto);
		if (userService.createUser(user)) {
			response.setHeader("Authorization", AppUtils.encryptBasic(user.getEmail(), user.getPassword()));
			return new ResponseEntity<UserResponseDTO>(UserMapper.mapEntityIntoDTO(user), HttpStatus.CREATED);
		}
		UserResponseDTO userResponse = new UserResponseDTO();
		userResponse.setErrorMessage("The email is already registered. Try another one!");
		return new ResponseEntity<UserResponseDTO>(userResponse, HttpStatus.CONFLICT);

	}

	@RequestMapping(path = "/reservation", method = RequestMethod.POST)
	public ResponseEntity<ReservationResponseDTO> makeAReservation(@RequestHeader("Authorization") String encoded,
			@RequestBody ReservationDTO reservationDTO) {
		ReservationResponseDTO reservationResponse;
		User user;

		String username = AppUtils.getUsernameFromBasic(encoded);
		String password = AppUtils.getPasswordFromBasic(encoded);
		if ((user = userRepository.findByEmailAndPassword(username, password)) == null) {
			reservationResponse = new ReservationResponseDTO();
			reservationResponse.setErrorMessage("You have to be logged to make a reservation.");
			return new ResponseEntity<ReservationResponseDTO>(reservationResponse, HttpStatus.UNAUTHORIZED);
					
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
		return new ResponseEntity<ReservationResponseDTO>(reservationResponse, HttpStatus.OK);
		
	}

	@RequestMapping(path = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ResponseErrorHandler> deleteUser(@RequestHeader("Authorization") String encoded,
			@PathVariable("id") Long userId) {
		ResponseErrorHandler errorResponse;
		AUser admin;
		
		String username = AppUtils.getUsernameFromBasic(encoded);
		String password = AppUtils.getPasswordFromBasic(encoded);
		if ((admin = aUserRepository.findByEmailAndPassword(username, password)) == null) {
			errorResponse = new ResponseErrorHandler();
			errorResponse.setErrorMessage("You have to be logged to delete user.");
			return new ResponseEntity<ResponseErrorHandler>(errorResponse, HttpStatus.UNAUTHORIZED);
					
		} if(admin.getRole() != Role.ADMIN) { 
			errorResponse = new ResponseErrorHandler();
			errorResponse.setErrorMessage("Only admins have privs to delete users.");
			return new ResponseEntity<ResponseErrorHandler>(errorResponse, HttpStatus.UNAUTHORIZED); //Ili FROBIDEN ili nesto drugo?? 
			
		}	// else successful login
	
		System.out.println("-----------------------------------------------------------"+userId);
		
		userRepository.delete(userId);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}
