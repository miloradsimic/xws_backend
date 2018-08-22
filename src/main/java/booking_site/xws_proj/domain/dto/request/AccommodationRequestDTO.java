package booking_site.xws_proj.domain.dto.request;

public class AccommodationRequestDTO {

	private String id_agent;
	private String description;
	private double price;

	public AccommodationRequestDTO() {
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

}
