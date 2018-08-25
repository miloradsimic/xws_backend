package booking_site.xws_proj.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import booking_site.xws_proj.domain.enums.Status;

@Entity
@Table(name = "tbl_comment")
public class Comment {
	@TableGenerator(name = "generator", initialValue = 10000)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	private Long id;
	@Column(nullable = false, name = "user_id")
	private long userId;
	@Column(nullable = false, name = "accommodation_id")
	private long accommodationId;
	@Column(nullable = false)
	private String text;
	@Column(nullable = false)
	private Status status;
	@Column(nullable = false, name = "comment_time")
	private Date time;

	public Comment() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getAccommodationId() {
		return accommodationId;
	}

	public void setAccommodationId(long accommodationId) {
		this.accommodationId = accommodationId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getStatusString() {
		switch (getStatus()) {
		case APPROVED:
			return "approved";
		case DISAPPROVED:
			return "disapproved";
		case WAITING_FOR_APPROVAL:
			return "waiting_for_approval";
		default:
			return "";
		}
	}

	public void setStatusString(String status) {
		switch (status) {
		case "approved":
			setStatus(Status.APPROVED);
		case "disapproved":
			setStatus(Status.DISAPPROVED);
			;
		case "waiting_for_approval":
			setStatus(Status.WAITING_FOR_APPROVAL);
			;
		default:
			return;
		}
	}

}
