package booking_site.xws_proj.controller;

import java.rmi.ServerException;
import java.rmi.ServerRuntimeException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import booking_site.xws_proj.AppUtils;
import booking_site.xws_proj.controller.exceptions.NotAuthorizedException;
import booking_site.xws_proj.controller.exceptions.NotFoundException;
import booking_site.xws_proj.controller.exceptions.NotLoggedException;
import booking_site.xws_proj.controller.exceptions.ReservationNotAvailableException;
import booking_site.xws_proj.domain.AUser;
import booking_site.xws_proj.domain.Accommodation;
import booking_site.xws_proj.domain.Reservation;
import booking_site.xws_proj.domain.dto.mappper.AccommodationMapper;
import booking_site.xws_proj.domain.dto.request.AccommodationRequestDTO;
import booking_site.xws_proj.domain.dto.request.CheckAvailabilityDTO;
import booking_site.xws_proj.domain.dto.request.ReservationRequestDTO;
import booking_site.xws_proj.domain.dto.request.SearchRequestDTO;
import booking_site.xws_proj.domain.dto.response.AccommodationResponseDTO;
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
	public ResponseEntity<AccommodationResponseDTO> create(HttpServletRequest request,
			@RequestBody AccommodationRequestDTO requestDto) {
		AUser anyUser;

		// check auth and autorization
		String encoded = request.getHeader("Authorization");
		String username = AppUtils.getUsernameFromBasic(encoded);
		String password = AppUtils.getPasswordFromBasic(encoded);
		if ((anyUser = aUserRepository.findByEmailAndPassword(username, password)) == null) {
			throw new NotLoggedException();
		}
		if (anyUser.getRole() != Role.AGENT) {
			throw new NotAuthorizedException();
		} // else permission granted

		Accommodation entry = AccommodationMapper.mapDtoIntoEntity(requestDto);
		AccommodationResponseDTO responseObject = AccommodationMapper
				.mapEntityIntoDTO(accommodationService.create(entry));

		return new ResponseEntity<AccommodationResponseDTO>(responseObject, HttpStatus.CREATED);
	}

	/*
	 * Read one
	 * 
	 * @return AccommodationResponseDTO
	 */
	@RequestMapping(path = "/accommodation/{id}", method = RequestMethod.GET)
	public ResponseEntity<AccommodationResponseDTO> readOne(@PathVariable("id") Long accommodationId) {
		AccommodationResponseDTO responseObject;
		if ((responseObject = AccommodationMapper
				.mapEntityIntoDTO(accommodationService.find(accommodationId))) == null) {
			throw new NotFoundException();
		}
		return new ResponseEntity<AccommodationResponseDTO>(responseObject, HttpStatus.OK);
	}

	/*
	 * Read all
	 * 
	 * @return List<AccommodationResponseDTO>
	 */
	@RequestMapping(path = "/accommodations", method = RequestMethod.GET)
	public ResponseEntity<List<AccommodationResponseDTO>> readAll() {
		List<AccommodationResponseDTO> list = new ArrayList<>();
		accommodationService.findAll().forEach(e -> list.add(AccommodationMapper.mapEntityIntoDTO(e)));
		return new ResponseEntity<List<AccommodationResponseDTO>>(list, HttpStatus.OK);

	}

	/*
	 * Update
	 * 
	 * @return AccommodationResponseDTO or ErrorResponse object
	 */
	@RequestMapping(path = "/accommodation", method = RequestMethod.PUT)
	public ResponseEntity<AccommodationResponseDTO> update(HttpServletRequest request,
			@RequestBody AccommodationRequestDTO requestDto) {
		AUser agent;

		String encoded = request.getHeader("Authorization");
		String username = AppUtils.getUsernameFromBasic(encoded);
		String password = AppUtils.getPasswordFromBasic(encoded);
		if ((agent = aUserRepository.findByEmailAndPassword(username, password)) == null) {
			throw new NotLoggedException();
		}
		if (agent.getRole() != Role.AGENT) {
			throw new NotAuthorizedException();
		}
		if (agent.getId() != requestDto.getId()) {
			throw new NotAuthorizedException("You can update only your accommodation.");
		} // else permission granted

		Accommodation entry = AccommodationMapper.mapDtoIntoEntity(requestDto);
		AccommodationResponseDTO responseObject = AccommodationMapper
				.mapEntityIntoDTO(accommodationService.update(entry));

		return new ResponseEntity<AccommodationResponseDTO>(responseObject, HttpStatus.OK);

	}

	/*
	 * Delete
	 * 
	 * @return Nothing or ErrorResponse object
	 */
	@RequestMapping(path = "/accommodation/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<AccommodationResponseDTO> delete(HttpServletRequest request,
			@PathVariable("id") Long accommodationId) {
		AUser agent;

		String encoded = request.getHeader("Authorization");
		String username = AppUtils.getUsernameFromBasic(encoded);
		String password = AppUtils.getPasswordFromBasic(encoded);
		if ((agent = aUserRepository.findByEmailAndPassword(username, password)) == null) {
			throw new NotLoggedException();
		}
		if (agent.getRole() != Role.AGENT) {
			throw new NotAuthorizedException();
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
	public ResponseEntity<ReservationResponseDTO> makeAReservation(HttpServletRequest request,
			@RequestBody ReservationRequestDTO reservationDTO) {
		AUser aUser;

		String encoded = request.getHeader("Authorization");
		String username = AppUtils.getUsernameFromBasic(encoded);
		String password = AppUtils.getPasswordFromBasic(encoded);
		if ((aUser = aUserRepository.findByEmailAndPassword(username, password)) == null) {
			throw new NotLoggedException();
		}
		if (aUser.getRole() != Role.AGENT && aUser.getRole() != Role.USER) {
			throw new NotAuthorizedException();
		} // else permission granted
		
		reservationDTO.setClient_id(aUser.getId());
		Reservation entry = accommodationService.reserveAccommodation(reservationDTO);
		
		if(entry == null) {
			throw new ReservationNotAvailableException();
		}
		
		ReservationResponseDTO responseDto = new ReservationResponseDTO(entry);
		
		return new ResponseEntity<ReservationResponseDTO>(responseDto, HttpStatus.CREATED);

	}
	
	/*
	 * Search accommodation
	 * 
	 * @return List<AccommodationResponseDTO>
	 */
	@RequestMapping(path = "/search", method = RequestMethod.POST)
	public ResponseEntity<List<Accommodation>> search(@RequestBody SearchRequestDTO requestDto) {
		
		System.out.println(requestDto.getTv());
		List<Accommodation> list = new ArrayList<>();
		list = accommodationService.search(requestDto);
		return new ResponseEntity<List<Accommodation>>(list, HttpStatus.OK);

	}
	
	/*
	 * Check availability
	 * 
	 * @return ReservationResponseDTO or ErrorResponse object
	 */
	@RequestMapping(path = "/check_if_available", method = RequestMethod.POST)
	public ResponseEntity<Boolean> checkAvailability(HttpServletRequest request,
			@RequestBody CheckAvailabilityDTO requestDto) {
		
		return new ResponseEntity<Boolean>(accommodationService.checkAvailability(requestDto), HttpStatus.OK);
	}
	

}


































