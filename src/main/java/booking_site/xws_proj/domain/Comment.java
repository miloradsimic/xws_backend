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

import booking_site.xws_proj.domain.enums.Status;

@Entity
@Table(name = "tbl_comment")
public class Comment {
	@TableGenerator(name = "generator", initialValue = 10000)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	private Long id;
	@ManyToOne // default fetch plan for ManyToOne is an EAGER
	@JoinColumn(name = "user_id" /* , insertable = false, updatable = false */)
	private User user;
	@ManyToOne // default fetch plan for ManyToOne is an EAGER
	@JoinColumn(name = "accommodation_id" /*
											 * , insertable = false, updatable =
											 * false
											 */)
	private Accommodation accommodation;
	@Column(nullable = false)
	private String text;
	@Column(nullable = false, name = "approval_state")
	private Status approvalState;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Accommodation getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(Accommodation accommodation) {
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

	public String getStatusString() {
		switch (getApprovalState()) {
		case APPROVED:
			return "Approved";
		case DISAPPROVED:
			return "Unapproved";
		case WAITING_FOR_APPROVAL:
			return "WaitingForApproval";
		default:
			return "";
		}
	}

	public void setStatusString(String status) {
		switch (status) {
		case "approved":
			setApprovalState(Status.APPROVED);
		case "disapproved":
			setApprovalState(Status.DISAPPROVED);
			;
		case "waiting_for_approval":
			setApprovalState(Status.WAITING_FOR_APPROVAL);
			;
		default:
			return;
		}
	}

}
