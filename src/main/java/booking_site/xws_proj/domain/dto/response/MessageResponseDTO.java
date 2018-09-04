package booking_site.xws_proj.domain.dto.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MessageResponseDTO {

	private Long id;
	private UserResponseDTO sender;
	private UserResponseDTO receiver;
	private String text;
	private Date time;

	public MessageResponseDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserResponseDTO getSender() {
		return sender;
	}

	public void setSender(UserResponseDTO sender) {
		this.sender = sender;
	}

	public UserResponseDTO getReceiver() {
		return receiver;
	}

	public void setReceiver(UserResponseDTO receiver) {
		this.receiver = receiver;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
