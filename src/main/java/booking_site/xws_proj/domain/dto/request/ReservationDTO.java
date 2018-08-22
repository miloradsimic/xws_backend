package booking_site.xws_proj.domain.dto.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservationDTO {

	public long user_id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	public Date startTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	public Date endTime;
	public long id_accommodation;

	public ReservationDTO() {
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
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

	public long getId_accommodation() {
		return id_accommodation;
	}

	public void setId_accommodation(long id_accommodation) {
		this.id_accommodation = id_accommodation;
	}

}
