package booking_site.xws_proj.domain.dto.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import booking_site.xws_proj.domain.AClient;
import booking_site.xws_proj.domain.Accommodation;
import booking_site.xws_proj.domain.Reservation;

public class ReservationDTO {
	@JsonInclude(Include.NON_NULL)
	private Long id;
	private AClient client;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date start_time;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date end_time;
	private Accommodation accommmodation;

	public ReservationDTO() {
	}

	public ReservationDTO(Reservation r) {
		id = r.getId();
		client = r.getClient();
		accommmodation = r.getAccommodation();
		start_time = r.getStartTime();
		end_time = r.getEndTime();
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

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public Accommodation getAccommmodation() {
		return accommmodation;
	}

	public void setAccommmodation(Accommodation accommmodation) {
		this.accommmodation = accommmodation;
	}

}
