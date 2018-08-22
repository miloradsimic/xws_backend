package booking_site.xws_proj.domain.dto.mappper;

import booking_site.xws_proj.domain.AUser;
import booking_site.xws_proj.domain.dto.response.UserResponseDTO;

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

		return dto;
	}
}
