package booking_site.xws_proj.domain.dto.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import booking_site.xws_proj.domain.enums.Status;

public class CommentResponseDTO {
	private Long id;
	private UserResponseDTO user;
	private AccommodationResponseDTO accommodation;
	private String text;
	private Status approvalState;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date time;

	public CommentResponseDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserResponseDTO getUser() {
		return user;
	}

	public void setUser(UserResponseDTO user) {
		this.user = user;
	}

	public AccommodationResponseDTO getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(AccommodationResponseDTO accommodation) {
		this.accommodation = accommodation;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Status getApprovalState() {
		return approvalState;
	}

	public void setApprovalState(Status approvalState) {
		this.approvalState = approvalState;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
