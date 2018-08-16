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
	// @Id
	// @GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private Date time;
	@Column(nullable = false)
	private long id_accomomdation;
	@Column(nullable = false)
	private String email_agent;
	
	public Reservation(){
		
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public long getId_accomomdation() {
		return id_accomomdation;
	}
	public void setId_accomomdation(long id_accomomdation) {
		this.id_accomomdation = id_accomomdation;
	}
	public String getEmail_agent() {
		return email_agent;
	}
	public void setEmail_agent(String email_agent) {
		this.email_agent = email_agent;
	}
	
	
}
