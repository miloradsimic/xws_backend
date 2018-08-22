package booking_site.xws_proj.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "tbl_reservation")
public class Reservation {

	@TableGenerator(name = "generator", initialValue = 10000)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	private long id;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false, name = "start_time")
	private Date startTime;
	@Column(nullable = false, name = "end_time")
	private Date endTime;
	@Column(nullable = false, name = "id_accommodation")
	private long idAccommomdation;
	@Column(nullable = false, name = "email_agent")
	private String emailAgent;

	public Reservation() {

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

	public long getIdAccommomdation() {
		return idAccommomdation;
	}

	public void setIdAccommomdation(long idAccommomdation) {
		this.idAccommomdation = idAccommomdation;
	}

	public String getEmailAgent() {
		return emailAgent;
	}

	public void setEmailAgent(String emailAgent) {
		this.emailAgent = emailAgent;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
