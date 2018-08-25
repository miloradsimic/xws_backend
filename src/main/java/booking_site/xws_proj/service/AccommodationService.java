package booking_site.xws_proj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import booking_site.xws_proj.domain.Accommodation;
import booking_site.xws_proj.repository.AccommodationRepository;

@Service
public class AccommodationService implements IAccommodationService {

	@Autowired
	private AccommodationRepository accommodationRepository;

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
}
