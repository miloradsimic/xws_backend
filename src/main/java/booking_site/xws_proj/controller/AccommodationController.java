package booking_site.xws_proj.controller;

import java.util.Date;

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
import booking_site.xws_proj.domain.Accommodation;
import booking_site.xws_proj.domain.dto.mappper.AccommodationMapper;
import booking_site.xws_proj.domain.dto.request.AccommodationRequestDTO;
import booking_site.xws_proj.domain.dto.request.ReservationDTO;
import booking_site.xws_proj.domain.dto.response.AccommodationResponseDTO;
import booking_site.xws_proj.domain.dto.response.ErrorResponse;
import booking_site.xws_proj.domain.dto.response.ReservationResponseDTO;
import booking_site.xws_proj.domain.enums.Role;
import booking_site.xws_proj.repository.AUserRepository;
import booking_site.xws_proj.service.IAccommodationService;

@RestController
@RequestMapping("/accommodation")
public class AccommodationController {

	@Autowired
	private IAccommodationService accommodationService;

	@Autowired
	private AUserRepository aUserRepository;

	/*
	 * Create
	 * 
	 * @return AccommodationResponseDTO or ErrorResponse object (unimplemented)
	 */
	@RequestMapping(path = "/accommodation", method = RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestHeader("Authorization") String encoded,
			@RequestBody AccommodationRequestDTO requestDto) {
		AUser anyUser;

		// check auth and autorization
		String username = AppUtils.getUsernameFromBasic(encoded);
		String password = AppUtils.getPasswordFromBasic(encoded);
		if ((anyUser = aUserRepository.findByEmailAndPassword(username, password)) == null) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setError("You have to be logged to make a reservation.");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNAUTHORIZED);
		}
		if (anyUser.getRole() != Role.AGENT) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setError("Only agents are authorizated for this action.");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNAUTHORIZED);
		} // else permission granted

		Accommodation entry = AccommodationMapper.mapDtoIntoEntity(requestDto);
		AccommodationResponseDTO responseObject = AccommodationMapper
				.mapEntityIntoDTO(accommodationService.create(entry));

		return new ResponseEntity<Object>(responseObject, HttpStatus.CREATED);
	}

	/*
	 * Read one
	 * 
	 * @return AccommodationResponseDTO
	 */
	@RequestMapping(path = "/accommodation/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> readOne(@PathVariable("id") Long accommodationId) {
		Accommodation responseObject;
		if ((responseObject = accommodationService.find(accommodationId)) == null) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setError("Not found.");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(responseObject, HttpStatus.OK);
	}

	/*
	 * Read all
	 * 
	 * @return List<AccommodationResponseDTO>
	 */
	@RequestMapping(path = "/accommodations", method = RequestMethod.GET)
	public ResponseEntity<Object> readAll() {
		return new ResponseEntity<Object>(accommodationService.findAll(), HttpStatus.OK);

	}

	/*
	 * Update
	 * 
	 * @return AccommodationResponseDTO or ErrorResponse object
	 */
	@RequestMapping(path = "/accommodation", method = RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestHeader("Authorization") String encoded,
			@RequestBody AccommodationRequestDTO requestDto) {
		AUser agent;

		String username = AppUtils.getUsernameFromBasic(encoded);
		String password = AppUtils.getPasswordFromBasic(encoded);
		if ((agent = aUserRepository.findByEmailAndPassword(username, password)) == null) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setError("You have to be logged to update accommodation.");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNAUTHORIZED);
		}
		if (agent.getRole() != Role.AGENT) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setError("Only agents can update accommodation.");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNAUTHORIZED);
		}
		if (agent.getId() != requestDto.getId()) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setError("You can update only your accommodation.");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNAUTHORIZED);
		} // else permission granted

		Accommodation entry = AccommodationMapper.mapDtoIntoEntity(requestDto);
		AccommodationResponseDTO responseObject = AccommodationMapper
				.mapEntityIntoDTO(accommodationService.update(entry));

		return new ResponseEntity<Object>(responseObject, HttpStatus.OK);

	}

	/*
	 * Delete
	 * 
	 * @return Nothing or ErrorResponse object
	 */
	@RequestMapping(path = "/accommodation/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@RequestHeader("Authorization") String encoded,
			@PathVariable("id") Long accommodationId) {
		AUser agent;

		String username = AppUtils.getUsernameFromBasic(encoded);
		String password = AppUtils.getPasswordFromBasic(encoded);
		if ((agent = aUserRepository.findByEmailAndPassword(username, password)) == null) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setError("You have to be logged to delete accommodation.");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNAUTHORIZED);
		}
		if (agent.getRole() != Role.AGENT) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setError("Only agents have privs to delete accommodations.");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNAUTHORIZED);
		} // else permission granted
			// TODO M: If there is any reservation in future, disable option
		accommodationService.delete(accommodationId);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	/*
	 * Reserve accommodation
	 * 
	 * @return ReservationResponseDTO or ErrorResponse object
	 */
	@RequestMapping(path = "/reservation", method = RequestMethod.POST)
	public ResponseEntity<Object> makeAReservatiosn(@RequestHeader("Authorization") String encoded,
			@RequestBody ReservationDTO reservationDTO) {
		ReservationResponseDTO reservationResponse;
		AUser aUser;

		String username = AppUtils.getUsernameFromBasic(encoded);
		String password = AppUtils.getPasswordFromBasic(encoded);
		if ((aUser = aUserRepository.findByEmailAndPassword(username, password)) == null) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setError("You have to be logged to make a reservation.");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNAUTHORIZED);

		} // else permission granted

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

}
