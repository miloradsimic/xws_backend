package booking_site.xws_proj.domain.dto.response;

import java.util.Date;

import booking_site.xws_proj.domain.Reservation;
import booking_site.xws_proj.domain.dto.mappper.AccommodationMapper;
import booking_site.xws_proj.domain.dto.mappper.UserMapper;

public class ReservationResponseDTO {

	private Long id;
	private UserResponseDTO client;
	private AccommodationResponseDTO accommodation;
	private Date from;
	private Date to;

	public ReservationResponseDTO() {
		super();
	}

	public ReservationResponseDTO(Reservation r) {

		if (r.getId() != null) {
			id = r.getId();
		}

		if (r.getClient() != null) {
			client = UserMapper.mapEntityIntoDTO(r.getClient());
		}
		accommodation = AccommodationMapper.mapEntityIntoDTO(r.getAccommodation());
		from = r.getStartTime();
		to = r.getEndTime();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserResponseDTO getClient() {
		return client;
	}

	public void setClient(UserResponseDTO client) {
		this.client = client;
	}

	public AccommodationResponseDTO getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(AccommodationResponseDTO accommodation) {
		this.accommodation = accommodation;
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

}
