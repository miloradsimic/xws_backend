package booking_site.xws_proj.dto.mapper;

import booking_site.xws_proj.domain.User;
import booking_site.xws_proj.dto.response.UserResponseDTO;

public class UserMapper {

	public static UserResponseDTO mapEntityIntoDTO(User entity) {

		if (entity == null) {
			return null;
		}
		UserResponseDTO dto = new UserResponseDTO();

		dto.email = entity.getEmail();
		dto.name = (entity.getName());
		dto.id = (entity.getId());

		return dto;
	}
}
