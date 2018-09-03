package booking_site.xws_proj.domain.dto.mappper;

import javax.jws.soap.SOAPBinding.Use;

import booking_site.xws_proj.domain.Accommodation;
import booking_site.xws_proj.domain.Agent;
import booking_site.xws_proj.domain.dto.request.AccommodationRequestDTO;
import booking_site.xws_proj.domain.dto.response.AccommodationResponseDTO;
import booking_site.xws_proj.domain.dto.response.UserResponseDTO;

public class AccommodationMapper {

	public static AccommodationResponseDTO mapEntityIntoDTO(Accommodation entity) {

		if (entity == null) {
			return null;
		}
		AccommodationResponseDTO dto = new AccommodationResponseDTO();

		dto.setId(entity.getId());
		dto.setAgent(UserMapper.mapEntityIntoDTO(entity.getAgent()));
		dto.setDescription(entity.getDescription());
		dto.setDailyPrice(entity.getDailyPrice());
		dto.setCategory(entity.getCategory());
		dto.setType(entity.getType());
		dto.setImageUri(entity.getImageUri());
		dto.setParking(entity.isParking());
		dto.setWifi(entity.isWifi());
		dto.setBreakfast(entity.isBreakfast());
		dto.setHalfBoard(entity.isHalfBoard());
		dto.setFullBoard(entity.isFullBoard());
		dto.setTv(entity.isTv());
		dto.setKitchen(entity.isKitchen());
		dto.setPrivateBathroom(entity.isPrivateBathroom());
		dto.setAddress(entity.getAddress());

		return dto;
	}

	public static Accommodation mapDtoIntoEntity(AccommodationRequestDTO dto) {

		if (dto == null) {
			return null;
		}
		Accommodation entity = new Accommodation();

		entity.setId(dto.getId());
		entity.setAgent(new Agent(dto.getAgent()));
		entity.setDescription(dto.getDescription());
		entity.setDailyPrice(dto.getDailyPrice());
		entity.setCategory(dto.getCategory());
		entity.setType(dto.getType());
		entity.setImageUri(dto.getImageUri());
		entity.setParking(dto.isParking());
		entity.setWifi(dto.isWifi());
		entity.setBreakfast(dto.isBreakfast());
		entity.setHalfBoard(dto.isHalfBoard());
		entity.setFullBoard(dto.isFullBoard());
		entity.setTv(dto.isTv());
		entity.setKitchen(dto.isKitchen());
		entity.setPrivateBathroom(dto.isPrivateBathroom());
		
		return entity;
	}

}
