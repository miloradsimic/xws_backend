package booking_site.xws_proj.domain.dto.mappper;

import booking_site.xws_proj.domain.AUser;
import booking_site.xws_proj.domain.dto.response.UserResponseDTO;

public class UserMapper {

	public static UserResponseDTO mapEntityIntoDTO(AUser aUser) {

		if (aUser == null) {
			return null;
		}
		UserResponseDTO dto = new UserResponseDTO();

		dto.email = aUser.getEmail();
		dto.name = aUser.getName();
		dto.role = aUser.getRoleString();

		return dto;
	}
}
