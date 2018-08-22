package booking_site.xws_proj.domain.dto.request;

public class UserLoginRequestDTO {

	private String email;
	private String password;

	public UserLoginRequestDTO() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
