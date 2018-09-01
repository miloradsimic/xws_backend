package booking_site.xws_proj.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class UserResponseDTO {

	private Long id;
	private String email;
	private String name;
	private String role;
	@JsonInclude(Include.NON_NULL)
	private Long tin;
	@JsonInclude(Include.NON_NULL)
	private Boolean active;

	public UserResponseDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Long getTin() {
		return tin;
	}

	public void setTin(Long tin) {
		this.tin = tin;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
