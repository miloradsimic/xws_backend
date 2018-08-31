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
		dto.setAgent_id(entity.getAgentId());
		dto.setDescription(entity.getDescription());
		dto.setPrice(entity.getDailyPrice());

		return dto;
	}

	public static Accommodation mapDtoIntoEntity(AccommodationRequestDTO dto) {

		if (dto == null) {
			return null;
		}
		Accommodation entity = new Accommodation();

		entity.setId(dto.getId());
		entity.setAgentId(dto.getAgent_id());
		entity.setDescription(dto.getDescription());
		entity.setDailyPrice(dto.getPrice());

		return entity;
	}

}
