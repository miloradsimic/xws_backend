package booking_site.xws_proj.service;

import java.util.List;

import booking_site.xws_proj.domain.Accommodation;

public interface IAccommodationService {

	// crud
	boolean create(Accommodation entry);

	Accommodation find(long id);

	Accommodation update(Accommodation entry);

	void delete(long id);

	// ostalo
	List<Accommodation> findAll();

}
