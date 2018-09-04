package booking_site.xws_proj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;

import booking_site.xws_proj.domain.Accommodation;
import booking_site.xws_proj.domain.Reservation;
import booking_site.xws_proj.domain.dto.request.CheckAvailabilityDTO;
import booking_site.xws_proj.domain.dto.request.ReservationDTO;
import booking_site.xws_proj.domain.dto.request.SearchRequestDTO;
import booking_site.xws_proj.domain.querydsl.predicates.ReservationPredicate;
import booking_site.xws_proj.repository.AccommodationRepository;
import booking_site.xws_proj.repository.ReservationRepository;

@Service
public class AccommodationService implements IAccommodationService {

	@Autowired
	private AccommodationRepository accommodationRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Override
	public Accommodation create(Accommodation entry) {
		return accommodationRepository.save(entry);

	}

	@Override
	public Accommodation find(long id) {
		return accommodationRepository.findOne(id);
	}

	@Override
	public Accommodation update(Accommodation entry) {
		if (accommodationRepository.exists(entry.getId())) {
			return accommodationRepository.save(entry);
		}
		return null;
	}

	@Override
	public void delete(long id) {
		if (accommodationRepository.exists(id)) {
			Accommodation entry = accommodationRepository.findOne(id);
			accommodationRepository.save(entry);
		}
	}

	@Override
	public List<Accommodation> findAll() {
		List<Accommodation> list = new ArrayList<>();
		accommodationRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public List<Accommodation> search(SearchRequestDTO dto) {
		ArrayList<Accommodation> list = new ArrayList<Accommodation>();
		ArrayList<Accommodation> list2 = new ArrayList<Accommodation>();
		ArrayList<Long> reserv = new ArrayList<Long>();

		Predicate pred = ReservationPredicate.findReserved(dto.getFrom(), dto.getTo());

		reservationRepository.findAll(pred).forEach(e -> reserv.add(e.getAccommodation().getId()));
		accommodationRepository.findAll().forEach(e -> list.add(e));
		for (Accommodation a : list) {
			list2.add(a);
			if (dto.getAddress() != null && !dto.getAddress().equals("")) {
				if (!a.getAddress().contains(dto.getAddress())) {
					list2.remove(a);
					continue;
				}
			}
			for (Long id : reserv) {
				if (a.getId() == id) {
					list2.remove(a);
				}
			}
		}

		return list2;
	}

	@Override
	public Boolean checkAvailability(CheckAvailabilityDTO requestDto) {

		ArrayList<Long> reserv = new ArrayList<Long>();

		Predicate pred = ReservationPredicate.findReserved(requestDto.getFrom(), requestDto.getTo(),
				requestDto.getAccommodation_id());

		reservationRepository.findAll(pred).forEach(e -> reserv.add(e.getAccommodation().getId()));

		if (reserv.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Reservation reserveAccommodation(ReservationDTO dto) {
		CheckAvailabilityDTO arg = new CheckAvailabilityDTO();
		arg.setAccommodation_id(dto.getAccommmodation().getId());
		arg.setFrom(dto.getStart_time());
		arg.setTo(dto.getEnd_time());

		if (checkAvailability(arg)) {
			Reservation e = new Reservation(dto);
			return reservationRepository.save(new Reservation(dto));
		}
		return null;

	}

}
