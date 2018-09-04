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

@Entity
@Table(name = "tbl_message")
public class Message {
	@TableGenerator(name = "generator", initialValue = 10000)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	private Long id;
	@ManyToOne // default fetch plan for ManyToOne is an EAGER
	@JoinColumn(name = "sender_id"/*, insertable = false, updatable = false*/)
	private AClient sender;
	@ManyToOne // default fetch plan for ManyToOne is an EAGER
	@JoinColumn(name = "receiver_id"/*, insertable = false, updatable = false*/)
	private AClient receiver;
	@Column(nullable = false)
	private String text;
	@Column(nullable = false, name = "message_time")
	private Date time;

	public Message() {
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

	@Override
	public String toString() {
		return "Message [id=" + id + ", sender=" + sender + ", receiver=" + receiver + ", text=" + text + ", time="
				+ time + "]";
	}

	
}
