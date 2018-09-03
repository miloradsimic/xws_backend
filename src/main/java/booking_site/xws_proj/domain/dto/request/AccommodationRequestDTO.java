package booking_site.xws_proj.domain.dto.request;

import booking_site.xws_proj.domain.dto.response.UserResponseDTO;
import booking_site.xws_proj.domain.enums.AccommodationType;

public class AccommodationRequestDTO {

	private Long id;
	private String description;
	private UserResponseDTO agent;
	private int category;
	private AccommodationType type;
	private String imageUri;
	private double dailyPrice;
	private String address;
	private boolean parking;
	private boolean wifi;
	private boolean breakfast;
	private boolean halfBoard;
	private boolean fullBoard;
	private boolean tv;
	private boolean kitchen;
	private boolean privateBathroom;

	public AccommodationRequestDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserResponseDTO getAgent() {
		return agent;
	}

	public void setAgent(UserResponseDTO agent) {
		this.agent = agent;
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

	

}
