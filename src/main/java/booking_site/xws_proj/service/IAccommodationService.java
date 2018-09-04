package booking_site.xws_proj.service;

import java.util.List;

import booking_site.xws_proj.domain.Accommodation;
import booking_site.xws_proj.domain.Reservation;
import booking_site.xws_proj.domain.dto.request.CheckAvailabilityDTO;
import booking_site.xws_proj.domain.dto.request.ReservationRequestDTO;
import booking_site.xws_proj.domain.dto.request.SearchRequestDTO;
import booking_site.xws_proj.domain.dto.response.AccommodationResponseDTO;
import booking_site.xws_proj.domain.dto.response.ReservationResponseDTO;

public interface IAccommodationService {

	// crud
	Accommodation create(Accommodation entry);

	Accommodation find(long id);

	Accommodation update(Accommodation entry);

	void delete(long id);

	// ostalo
	List<Accommodation> findAll();
	
	List<Accommodation> search(SearchRequestDTO dto);

	Boolean checkAvailability(CheckAvailabilityDTO requestDto);
	
	Reservation reserveAccommodation(ReservationRequestDTO dto);

	List<ReservationResponseDTO> findAllReservationsForUser(Long userId);

	List<ReservationResponseDTO> findAllReservationsForAccommodation(Long accommodationId);

	Boolean cancelReservation(Long id, Long accommodationId);
 }
