package booking_site.xws_proj.domain.dto.mappper;

import booking_site.xws_proj.domain.Accommodation;
import booking_site.xws_proj.domain.dto.request.AccommodationRequestDTO;
import booking_site.xws_proj.domain.dto.response.AccommodationResponseDTO;

public class AccommodationMapper {

	public static AccommodationResponseDTO mapEntityIntoDTO(Accommodation entity) {

		if (entity == null) {
			return null;
		}
		AccommodationResponseDTO dto = new AccommodationResponseDTO();

		dto.setId(entity.getId());
		dto.setId_agent(entity.getIdAgent());
		dto.setDescription(entity.getDescription());
		dto.setPrice(entity.getPrice());

		return dto;
	}

	public static Accommodation mapDtoIntoEntity(AccommodationRequestDTO dto) {

		if (dto == null) {
			return null;
		}
		Accommodation entity = new Accommodation();

		entity.setId(dto.getId());
		entity.setIdAgent(dto.getId_agent());
		entity.setDescription(dto.getDescription());
		entity.setPrice(dto.getPrice());

		return entity;
	}

}
