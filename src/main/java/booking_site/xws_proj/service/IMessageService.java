package booking_site.xws_proj.service;

import java.util.List;

import booking_site.xws_proj.domain.AUser;
import booking_site.xws_proj.domain.dto.request.MessageRequestDTO;
import booking_site.xws_proj.domain.dto.response.MessageResponseDTO;

public interface IMessageService {
	// crud
	MessageResponseDTO create(MessageRequestDTO entry, AUser client);

	// ostalo
	List<MessageResponseDTO> findAllReceived(AUser client);

	List<MessageResponseDTO> findAllSent(AUser client);
}
