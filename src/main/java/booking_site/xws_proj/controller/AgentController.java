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

import com.querydsl.core.types.Predicate;

import booking_site.xws_proj.AppUtils;
import booking_site.xws_proj.controller.exceptions.AlreadyExistsException;
import booking_site.xws_proj.controller.exceptions.NotAuthorizedException;
import booking_site.xws_proj.controller.exceptions.NotLoggedException;
import booking_site.xws_proj.domain.AUser;
import booking_site.xws_proj.domain.Agent;
import booking_site.xws_proj.domain.dto.mappper.UserMapper;
import booking_site.xws_proj.domain.dto.request.UserRegisterRequestDTO;
import booking_site.xws_proj.domain.dto.response.UserResponseDTO;
import booking_site.xws_proj.domain.enums.Role;
import booking_site.xws_proj.domain.querydsl.predicates.UserPredicates;
import booking_site.xws_proj.repository.AUserRepository;

@RestController
@RequestMapping("/agent")
public class AgentController {

	@Autowired
	private AUserRepository aUserRepository;

	/*
	 * Create
	 * 
	 * @return UserResponseDTO
	 */
	@RequestMapping(path = "/agent", method = RequestMethod.POST)
	public ResponseEntity<UserResponseDTO> create(HttpServletRequest request,
			@RequestBody UserRegisterRequestDTO userDto, HttpServletResponse response) {

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

		Agent agent;
		try {
			agent = aUserRepository.save(new Agent(userDto));
		} catch (Exception e) {
			throw new AlreadyExistsException();
		}

		return new ResponseEntity<UserResponseDTO>(UserMapper.mapEntityIntoDTO(agent), HttpStatus.CREATED);
	}

	/*
	 * Read one
	 */
	@RequestMapping(path = "/agent/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserResponseDTO> readOne(@PathVariable("id") Long id) {
		Predicate findAgent = UserPredicates.findAgent(id);
		return new ResponseEntity<UserResponseDTO>(UserMapper.mapEntityIntoDTO(aUserRepository.findOne(findAgent)),
				HttpStatus.OK);
	}

	/*
	 * Read all
	 */
	@RequestMapping(path = "/agents", method = RequestMethod.GET)
	public ResponseEntity<List<UserResponseDTO>> readAll() {
		List<UserResponseDTO> list = new ArrayList<UserResponseDTO>();
		Predicate findAgents = UserPredicates.findAgents();
		aUserRepository.findAll(findAgents).forEach(e -> list.add(UserMapper.mapEntityIntoDTO(e)));
		return new ResponseEntity<List<UserResponseDTO>>(list, HttpStatus.OK);
	}

}
