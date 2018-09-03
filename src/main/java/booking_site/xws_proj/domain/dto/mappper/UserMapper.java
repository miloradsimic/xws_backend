package booking_site.xws_proj.domain.dto.mappper;

import booking_site.xws_proj.domain.AUser;
import booking_site.xws_proj.domain.Agent;
import booking_site.xws_proj.domain.User;
import booking_site.xws_proj.domain.dto.response.UserResponseDTO;
import booking_site.xws_proj.domain.enums.Role;

public class UserMapper {

	public static UserResponseDTO mapEntityIntoDTO(AUser aUser) {

		if (aUser == null) {
			return null;
		}
		UserResponseDTO dto = new UserResponseDTO();

		dto.setId(aUser.getId());
		dto.setEmail(aUser.getEmail());
		dto.setName(aUser.getName());
		dto.setRole(aUser.getRoleString());
		dto.setAddress(aUser.getAddress());
		if (aUser.getRole() == Role.USER) {
			dto.setActive(((User) aUser).isActive());
		}
		if (aUser.getRole() == Role.AGENT) {
			dto.setTin(((Agent) aUser).getTin());
		}

		return dto;
	}
}
