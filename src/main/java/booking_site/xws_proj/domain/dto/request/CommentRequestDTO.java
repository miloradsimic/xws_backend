package booking_site.xws_proj.domain.dto.request;

public class CommentRequestDTO {
	private Long accommodation_id;
	private String text;

	public CommentRequestDTO() {
	}

	public Long getAccommodation_id() {
		return accommodation_id;
	}

	public void setAccommodation_id(Long accommodation_id) {
		this.accommodation_id = accommodation_id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
