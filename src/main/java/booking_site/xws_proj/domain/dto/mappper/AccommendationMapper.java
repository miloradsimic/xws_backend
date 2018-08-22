package booking_site.xws_proj.domain.dto.mappper;

import booking_site.xws_proj.domain.Accommodation;
import booking_site.xws_proj.domain.dto.request.AccommodationRequestDTO;
import booking_site.xws_proj.domain.dto.response.AccommodationResponseDTO;

public class AccommendationMapper {

	public static AccommodationResponseDTO mapEntityIntoDTO(Accommodation entity) {

		if (entity == null) {
			return null;
		}
		AccommodationResponseDTO dto = new AccommodationResponseDTO();

		dto.setId_agent(entity.getId_agent());
		dto.setDescription(entity.getDescription());
		dto.setPrice(entity.getPrice());

		return dto;
	}

	public static Accommodation mapDtoIntoEntity(AccommodationRequestDTO dto) {

		if (dto == null) {
			return null;
		}
		Accommodation entity = new Accommodation();

		entity.setId_agent(dto.getId_agent());
		entity.setDescription(dto.getDescription());
		entity.setPrice(dto.getPrice());

		return entity;
	}

}
