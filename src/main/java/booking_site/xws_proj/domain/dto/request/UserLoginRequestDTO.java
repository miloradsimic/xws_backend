package booking_site.xws_proj.domain.dto.request;

import booking_site.xws_proj.domain.AUser;

public class UserLoginRequestDTO {

	public String email;
	public String password;

	public UserLoginRequestDTO() {
	}
	public UserLoginRequestDTO(AUser user) {
		this.email = user.getEmail();
		this.password = user.getPassword();
	}
}
