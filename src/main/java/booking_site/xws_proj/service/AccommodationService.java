package booking_site.xws_proj.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;

import booking_site.xws_proj.domain.AClient;
import booking_site.xws_proj.domain.Accommodation;
import booking_site.xws_proj.domain.Reservation;
import booking_site.xws_proj.domain.dto.request.CheckAvailabilityDTO;
import booking_site.xws_proj.domain.dto.request.ReservationRequestDTO;
import booking_site.xws_proj.domain.dto.request.SearchRequestDTO;
import booking_site.xws_proj.domain.querydsl.predicates.ReservationPredicate;
import booking_site.xws_proj.repository.AUserRepository;
import booking_site.xws_proj.repository.AccommodationRepository;
import booking_site.xws_proj.repository.ReservationRepository;

@Service
public class AccommodationService implements IAccommodationService {

	@Autowired
	private AccommodationRepository accommodationRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private AUserRepository aUserRepository;

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

//		ArrayList<Long> reserv = new ArrayList<Long>();
//
//		Predicate pred = ReservationPredicate.findReserved(requestDto.getFrom(), requestDto.getTo(),
//				requestDto.getAccommodation_id());
//
//		reservationRepository.findAll(pred).forEach(e -> reserv.add(e.getAccommodation().getId()));
//		
		ArrayList<Reservation> reserv = new ArrayList<Reservation>();

		Predicate pred = ReservationPredicate.findReserved(requestDto.getFrom(), requestDto.getTo(),
				requestDto.getAccommodation_id());

		reservationRepository.findAll(pred).forEach(e -> reserv.add(e));
		
		for (Reservation reservation : reserv) {
			System.out.println(reservation.toString());
		}
		
		if (reserv.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Reservation reserveAccommodation(ReservationRequestDTO dto) {
		CheckAvailabilityDTO arg = new CheckAvailabilityDTO();
		arg.setAccommodation_id(dto.getAccommodation_id());
		arg.setFrom(dto.getFrom());
		arg.setTo(dto.getTo());
		System.out.println("from:  "+ dto.getFrom() + "   to:  " + dto.getTo() + "  id:  " + dto.getAccommodation_id());

		if (checkAvailability(arg)) {
			AClient c = ((AClient)aUserRepository.findOne(dto.getClient_id()));
			Accommodation a = accommodationRepository.findOne(dto.getAccommodation_id());
			Reservation e = new Reservation(dto, c,	a);

			System.out.println(e.toString());
			return reservationRepository.save(e);
		}
		return null;

	}

}
