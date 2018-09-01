package booking_site.xws_proj.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import booking_site.xws_proj.domain.enums.AccommodationType;

@Entity
@Table(name = "tbl_accommodation")
public class Accommodation {

	@TableGenerator(name = "generator", initialValue = 10000)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	private Long id;
	@Column(nullable = false, name = "agent_id")
	private long agentId;
	@Column(nullable = true)
	private int category;
	@Column(nullable = false, name = "accommodation_type")
	private AccommodationType type;
	@Column(nullable = false, name = "image_uri")
	private String imageUri;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false, name = "daily_price")
	private double dailyPrice;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private boolean parking;
	@Column(nullable = false)
	private boolean wifi;
	@Column(nullable = false)
	private boolean breakfast;
	@Column(nullable = false, name = "half_board")
	private boolean halfBoard;
	@Column(nullable = false, name = "full_board")
	private boolean fullBoard;
	@Column(nullable = false)
	private boolean tv;
	@Column(nullable = false)
	private boolean kitchen;
	@Column(nullable = false, name = "private_bathroom")
	private boolean privateBathroom;

	public Accommodation() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getAgentId() {
		return agentId;
	}

	public void setAgentId(long agentId) {
		this.agentId = agentId;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public AccommodationType getType() {
		return type;
	}

	public void setType(AccommodationType type) {
		this.type = type;
	}

	public String getImageUri() {
		return imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}

	public boolean isParking() {
		return parking;
	}

	public void setParking(boolean parking) {
		this.parking = parking;
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public boolean isBreakfast() {
		return breakfast;
	}

	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}

	public boolean isHalfBoard() {
		return halfBoard;
	}

	public void setHalfBoard(boolean halfBoard) {
		this.halfBoard = halfBoard;
	}

	public boolean isFullBoard() {
		return fullBoard;
	}

	public void setFullBoard(boolean fullBoard) {
		this.fullBoard = fullBoard;
	}

	public boolean isTv() {
		return tv;
	}

	public void setTv(boolean tv) {
		this.tv = tv;
	}

	public boolean isKitchen() {
		return kitchen;
	}

	public void setKitchen(boolean kitchen) {
		this.kitchen = kitchen;
	}

	public boolean isPrivateBathroom() {
		return privateBathroom;
	}

	public void setPrivateBathroom(boolean privateBathroom) {
		this.privateBathroom = privateBathroom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(double dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
