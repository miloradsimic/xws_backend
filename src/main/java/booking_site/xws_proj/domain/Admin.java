package booking_site.xws_proj.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import booking_site.xws_proj.domain.enums.Role;

@Entity
@Table(name = "tbl_admin")
public class Admin extends AUser {

	public Admin() {
		role = Role.ADMIN;
	}

}
