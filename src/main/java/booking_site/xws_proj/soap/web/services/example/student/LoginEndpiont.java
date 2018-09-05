package booking_site.xws_proj.soap.web.services.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import booking_site.xws_proj.AppUtils;
import booking_site.xws_proj.controller.exceptions.LoginFailedException;
import booking_site.xws_proj.domain.dto.mappper.UserMapper;
import booking_site.xws_proj.domain.dto.response.UserResponseDTO;
import booking_site.xws_proj.domain.enums.Role;
import booking_site.xws_proj.repository.AUserRepository;
import booking_site.xws_proj.soap.beans.AgentDetails;
import booking_site.xws_proj.soap.beans.GetLoginRequest;
import booking_site.xws_proj.soap.beans.GetLoginResponse;

@Endpoint
public class LoginEndpiont {

	@Autowired
	AUserRepository aRepository;

	@PayloadRoot(namespace = "http://beans.soap.xws_proj.booking_site", localPart = "GetLoginRequest")
	@ResponsePayload
	public GetLoginResponse processLoginRequest(@RequestPayload GetLoginRequest request) {
		GetLoginResponse response = new GetLoginResponse();

		UserResponseDTO userResponse = UserMapper
				.mapEntityIntoDTO(aRepository.findByEmailAndPassword(request.getEmail(), request.getPassword()));
		if (userResponse == null || aRepository.findOne(userResponse.getId()).getRole() != Role.AGENT) {
			throw new LoginFailedException();
		}
		AgentDetails a = new AgentDetails();
		a.setId(userResponse.getId());
		a.setName(userResponse.getName());
		a.setAuthToken(AppUtils.encryptBasic(request.getEmail(), request.getPassword()));

		response.setAgentDetails(a);

		return response;
	}
}
