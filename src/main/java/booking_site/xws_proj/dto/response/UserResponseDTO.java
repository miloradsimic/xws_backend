package booking_site.xws_proj.dto.response;

import booking_site.xws_proj.domain.User;

public class UserResponseDTO {

	public long id;
	public String email;
	public String name;

	public UserResponseDTO() {
	}
	public UserResponseDTO(User user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.name = user.getName();
	}
}
