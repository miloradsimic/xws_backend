package booking_site.xws_proj.domain.dto.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import booking_site.xws_proj.domain.AClient;

public class MessageResponseDTO {

	private Long id;
	private AClient sender;
	private AClient receiver;
	private String text;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date time;

	public MessageResponseDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AClient getSender() {
		return sender;
	}

	public void setSender(AClient sender) {
		this.sender = sender;
	}

	public AClient getReceiver() {
		return receiver;
	}

	public void setReceiver(AClient receiver) {
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
