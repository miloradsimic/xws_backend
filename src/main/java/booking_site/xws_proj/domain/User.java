package booking_site.xws_proj.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import booking_site.xws_proj.domain.dto.request.UserRegisterRequestDTO;
import booking_site.xws_proj.domain.enums.Role;


@Entity
@Table(name = "tbl_user")
public class User extends AUser {
	
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
		this.email = userDto.email;
		this.name = userDto.name;
		this.password = userDto.password;
		
		role = Role.USER;
		deleted = false;
		active = true;
	}

}
