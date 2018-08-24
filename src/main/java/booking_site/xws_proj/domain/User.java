package booking_site.xws_proj.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import booking_site.xws_proj.domain.dto.request.UserRegisterRequestDTO;
import booking_site.xws_proj.domain.enums.Role;

@Entity
@Table(name = "tbl_user")
public class User extends AClient {

	public boolean deleted;
	public boolean active;

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public User() {

		role = Role.USER;
		deleted = false;
		active = true;
	}

	public User(UserRegisterRequestDTO userDto) {
		this.email = userDto.getEmail();
		this.name = userDto.getName();
		this.password = userDto.getPassword();

		role = Role.USER;
		deleted = false;
		active = true;
	}

}
