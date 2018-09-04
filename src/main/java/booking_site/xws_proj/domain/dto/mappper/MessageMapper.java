package booking_site.xws_proj.domain.dto.mappper;

import java.util.Date;

import booking_site.xws_proj.domain.AClient;
import booking_site.xws_proj.domain.AUser;
import booking_site.xws_proj.domain.Message;
import booking_site.xws_proj.domain.dto.request.MessageRequestDTO;
import booking_site.xws_proj.domain.dto.response.MessageResponseDTO;

public class MessageMapper {
	public static MessageResponseDTO mapEntityIntoDTO(Message entity) {

		if (entity == null) {
			return null;
		}

		MessageResponseDTO dto = new MessageResponseDTO();

		dto.setId(entity.getId());
		dto.setReceiver(entity.getReceiver());
		dto.setSender(entity.getSender());
		dto.setText(entity.getText());
		dto.setTime(entity.getTime());

		return dto;
	}

	public static Message mapDtoIntoEntity(MessageRequestDTO dto, AUser sender, AUser receiver) {

		if (dto == null) {
			return null;
		}
		Message entity = new Message();

		entity.setReceiver((AClient) receiver);
		entity.setSender((AClient) sender);
		entity.setText(dto.getText());
		entity.setTime(new Date());

		return entity;
	}

}
