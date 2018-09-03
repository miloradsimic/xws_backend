package booking_site.xws_proj.domain.dto.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CheckAvailabilityDTO {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date from;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date to;
	private Long accommodation_id;

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Long getAccommodation_id() {
		return accommodation_id;
	}

	public void setAccommodation_id(Long accommodation_id) {
		this.accommodation_id = accommodation_id;
	}

}
