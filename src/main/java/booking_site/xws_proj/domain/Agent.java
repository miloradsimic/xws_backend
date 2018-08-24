package booking_site.xws_proj.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import booking_site.xws_proj.domain.enums.Role;

@Entity
@Table(name = "tbl_agent")
public class Agent extends AClient {

	public Agent() {
		role = Role.AGENT;
	}
}
