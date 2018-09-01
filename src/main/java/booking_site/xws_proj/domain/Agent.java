package booking_site.xws_proj.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import booking_site.xws_proj.domain.dto.request.UserRegisterRequestDTO;
import booking_site.xws_proj.domain.enums.Role;

@Entity
@Table(name = "tbl_agent")
public class Agent extends AClient {
	/*
	 * TIN in English is same as PIB in Serbian
	 */
	@Column(nullable = false)
	private Long tin;

	public Agent() {
		role = Role.AGENT;
	}

	public Agent(UserRegisterRequestDTO agentDto) {
		this.email = agentDto.getEmail();
		this.name = agentDto.getName();
		this.password = agentDto.getPassword();
		this.address = agentDto.getAddress();
		this.tin = agentDto.getTin();

		role = Role.AGENT;
	}

	public Long getTin() {
		return tin;
	}

	public void setTin(Long tin) {
		this.tin = tin;
	}

}
