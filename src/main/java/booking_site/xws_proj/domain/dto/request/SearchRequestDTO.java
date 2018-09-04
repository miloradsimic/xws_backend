package booking_site.xws_proj.domain.dto.request;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import booking_site.xws_proj.domain.enums.AccommodationType;

public class SearchRequestDTO {
	private String address;
	private Date from;
	private Date to;
	@JsonInclude(Include.NON_NULL)
	private ArrayList<Integer> category;
	@JsonInclude(Include.NON_NULL)
	private ArrayList<AccommodationType> type;
	@JsonInclude(Include.NON_NULL)
	private Boolean parking;
	@JsonInclude(Include.NON_NULL)
	private Boolean wifi;
	@JsonInclude(Include.NON_NULL)
	private Boolean breakfast;
	@JsonInclude(Include.NON_NULL)
	private Boolean halfBoard;
	@JsonInclude(Include.NON_NULL)
	private Boolean fullBoard;
	@JsonInclude(Include.NON_NULL)
	private Boolean tv;
	@JsonInclude(Include.NON_NULL)
	private Boolean kitchen;
	@JsonInclude(Include.NON_NULL)
	private Boolean privateBathroom;

	public SearchRequestDTO() {
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public ArrayList<Integer> getCategory() {
		return category;
	}

	public void setCategory(ArrayList<Integer> category) {
		this.category = category;
	}

	public ArrayList<AccommodationType> getType() {
		return type;
	}

	public void setType(ArrayList<AccommodationType> type) {
		this.type = type;
	}

	public Boolean getParking() {
		return parking;
	}

	public void setParking(Boolean parking) {
		this.parking = parking;
	}

	public Boolean getWifi() {
		return wifi;
	}

	public void setWifi(Boolean wifi) {
		this.wifi = wifi;
	}

	public Boolean getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(Boolean breakfast) {
		this.breakfast = breakfast;
	}

	public Boolean getHalfBoard() {
		return halfBoard;
	}

	public void setHalfBoard(Boolean halfBoard) {
		this.halfBoard = halfBoard;
	}

	public Boolean getFullBoard() {
		return fullBoard;
	}

	public void setFullBoard(Boolean fullBoard) {
		this.fullBoard = fullBoard;
	}

	public Boolean getTv() {
		return tv;
	}

	public void setTv(Boolean tv) {
		this.tv = tv;
	}

	public Boolean getKitchen() {
		return kitchen;
	}

	public void setKitchen(Boolean kitchen) {
		this.kitchen = kitchen;
	}

	public Boolean getPrivateBathroom() {
		return privateBathroom;
	}

	public void setPrivateBathroom(Boolean privateBathroom) {
		this.privateBathroom = privateBathroom;
	}

	

	
	
}
