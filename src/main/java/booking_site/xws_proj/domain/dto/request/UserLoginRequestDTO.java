package booking_site.xws_proj.dto.request;

import booking_site.xws_proj.domain.User;

public class UserLoginRequestDTO {

	public String email;
	public String password;

	public UserLoginRequestDTO() {
	}
	public UserLoginRequestDTO(User user) {
		this.email = user.getEmail();
		this.password = user.getPassword();
	}
}
