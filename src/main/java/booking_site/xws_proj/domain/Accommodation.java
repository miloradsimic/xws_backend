package booking_site.xws_proj.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "tbl_accommodation")
public class Accommodation {

	@TableGenerator(name = "generator", initialValue = 10000)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	// @Id
	// @GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
	@Column(nullable = false)
	private String id_agent;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private double price;
	@Column(nullable = false)
	private boolean deleted;

	public Accommodation() {
		deleted = false;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getId_agent() {
		return id_agent;
	}

	public void setId_agent(String id_agent) {
		this.id_agent = id_agent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
