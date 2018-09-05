package booking_site.xws_proj.soap.web.services.example.student;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import booking_site.xws_proj.AppUtils;
import booking_site.xws_proj.controller.exceptions.LoginFailedException;
import booking_site.xws_proj.controller.exceptions.NotAuthorizedException;
import booking_site.xws_proj.controller.exceptions.NotLoggedException;
import booking_site.xws_proj.domain.AUser;
import booking_site.xws_proj.domain.Accommodation;
import booking_site.xws_proj.domain.dto.mappper.UserMapper;
import booking_site.xws_proj.domain.dto.response.UserResponseDTO;
import booking_site.xws_proj.domain.enums.Role;
import booking_site.xws_proj.repository.AUserRepository;
import booking_site.xws_proj.service.AccommodationService;
import booking_site.xws_proj.soap.beans.Accommodations;
import booking_site.xws_proj.soap.beans.AgentDetails;
import booking_site.xws_proj.soap.beans.GetAllAccommodationsRequest;
import booking_site.xws_proj.soap.beans.GetAllAccommodationsResponse;
import booking_site.xws_proj.soap.beans.GetLoginRequest;
import booking_site.xws_proj.soap.beans.GetLoginResponse;

@Endpoint
public class LoginEndpiont {

	@Autowired
	AUserRepository aUserRepository;

	@Autowired
	AccommodationService accommodationService;

	@PayloadRoot(namespace = "http://beans.soap.xws_proj.booking_site", localPart = "GetLoginRequest")
	@ResponsePayload
	public GetLoginResponse processLoginRequest(@RequestPayload GetLoginRequest request) {
		GetLoginResponse response = new GetLoginResponse();

		UserResponseDTO userResponse = UserMapper
				.mapEntityIntoDTO(aUserRepository.findByEmailAndPassword(request.getEmail(), request.getPassword()));
		if (userResponse == null || aUserRepository.findOne(userResponse.getId()).getRole() != Role.AGENT) {
			throw new LoginFailedException();
		}
		AgentDetails a = new AgentDetails();
		a.setId(userResponse.getId());
		a.setName(userResponse.getName());
		a.setAuthToken(AppUtils.encryptBasic(request.getEmail(), request.getPassword()));

		response.setAgentDetails(a);

		return response;
	}

	@PayloadRoot(namespace = "http://beans.soap.xws_proj.booking_site", localPart = "GetAllAccommodationsRequest")
	@ResponsePayload
	public GetAllAccommodationsResponse processAccommodationsRequest(
			@RequestPayload GetAllAccommodationsRequest request) {
		GetAllAccommodationsResponse response = new GetAllAccommodationsResponse();

		AUser user;

		String encoded = request.getAuthToken();
		String username = AppUtils.getUsernameFromBasic(encoded);
		String password = AppUtils.getPasswordFromBasic(encoded);
		if ((user = aUserRepository.findByEmailAndPassword(username, password)) == null) {
			throw new NotLoggedException();
		}
		if (user.getRole() != Role.AGENT) {
			throw new NotAuthorizedException();
		} // else permission granted

		Accommodations accommodations = new Accommodations();
		accommodations.setAuthToken(request.getAuthToken());
		List<Accommodation> list = accommodationService.findAll(request.getId());
		for (Accommodation a : list) {
			booking_site.xws_proj.soap.beans.Accommodation e = new booking_site.xws_proj.soap.beans.Accommodation();
			e.setAddress(a.getAddress());
			String type = "";
			switch (a.getType()) {
			case HOTEL: {
				type = "hotel";
				break;
			}
			case BED_AND_BREAKFAST: {
				type = "bed_and_breakfast";
				break;
			}
			case APARTMAN: {
				type = "apartman";
				break;
			}
			default:
				break;
			}
			e.setType(type);
			e.setCategory(a.getCategory());
			e.setDescription(a.getDescription());
			e.setImageUri(a.getImageUri());
			e.setId(a.getId());

			accommodations.getAccommodation().add(e);
//			System.out.println("bio sam u foru");
		}
//		Iterator<booking_site.xws_proj.soap.beans.Accommodation> i =accommodations.getAccommodation().iterator(); 
//		while (i.hasNext()) {
//			System.out.println(i.next().getId());
//		}
		
		response.setAccommodations(accommodations);

		return response;
	}

}
