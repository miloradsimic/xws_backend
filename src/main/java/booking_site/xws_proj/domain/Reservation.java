package booking_site.xws_proj.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import booking_site.xws_proj.domain.dto.request.ReservationRequestDTO;
import booking_site.xws_proj.domain.enums.Status;

@Entity
@Table(name = "tbl_reservation")
public class Reservation {

	@TableGenerator(name = "generator", initialValue = 10000)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "client_id" /* , insertable = false, updatable = false */)
	private AClient client;
	@ManyToOne
	@JoinColumn(name = "accommodation_id" /*
											 * , insertable = false, updatable =
											 * false
											 */)
	private Accommodation accommodation;
	@Column(nullable = false, name = "start_time")
	private Date startTime;
	@Column(nullable = false, name = "end_time")
	private Date endTime;
	@Column(nullable = false)
	private Status status;

	public Reservation() {
		status = Status.WAITING_FOR_APPROVAL;
	}

	public Reservation(ReservationRequestDTO dto, AClient c, Accommodation a) {
		client = c;
		startTime = dto.getFrom();
		endTime = dto.getTo();
		accommodation = a;
		status = Status.WAITING_FOR_APPROVAL;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AClient getClient() {
		return client;
	}

	public void setClient(AClient client) {
		this.client = client;
	}

	public Accommodation getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(Accommodation accommodation) {
		this.accommodation = accommodation;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", client=" + client + ", accommodation=" + accommodation + ", startTime="
				+ startTime + ", endTime=" + endTime + ", status=" + status + "]";
	}
	
	

}
