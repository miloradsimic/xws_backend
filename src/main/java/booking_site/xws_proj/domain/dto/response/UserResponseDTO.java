package booking_site.xws_proj.domain.dto.response;

import booking_site.xws_proj.domain.User;

// TODO: Remove if not needed later.
public class UserResponseDTO extends ResponseErrorHandler {

	public long id;
	public String email;
	public String name;
	public String role;

	public UserResponseDTO() {
	}

	public UserResponseDTO(User user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.name = user.getName();
		this.role = user.getRoleString();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
