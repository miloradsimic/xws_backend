package booking_site.xws_proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import booking_site.xws_proj.AppUtils;
import booking_site.xws_proj.domain.AUser;
import booking_site.xws_proj.domain.Accommodation;
import booking_site.xws_proj.domain.dto.mappper.AccommendationMapper;
import booking_site.xws_proj.domain.dto.request.AccommodationRequestDTO;
import booking_site.xws_proj.domain.dto.response.ErrorResponse;
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
	 * @return AccommodationResponseDTO or ErrorResponse object (unimplemented)
	 */
	@RequestMapping(path = "/new", method = RequestMethod.POST)
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
		} // else successful login

		Accommodation entry = AccommendationMapper.mapDtoIntoEntity(requestDto);
		accommodationService.create(entry);

		return new ResponseEntity<Object>(AccommendationMapper.mapEntityIntoDTO(entry), HttpStatus.CREATED);

	}

}
