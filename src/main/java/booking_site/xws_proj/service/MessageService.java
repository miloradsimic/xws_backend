package booking_site.xws_proj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;

import booking_site.xws_proj.controller.exceptions.NotAuthorizedException;
import booking_site.xws_proj.controller.exceptions.NotLoggedException;
import booking_site.xws_proj.controller.exceptions.ServerErrorException;
import booking_site.xws_proj.domain.AUser;
import booking_site.xws_proj.domain.Message;
import booking_site.xws_proj.domain.dto.mappper.MessageMapper;
import booking_site.xws_proj.domain.dto.request.MessageRequestDTO;
import booking_site.xws_proj.domain.dto.response.MessageResponseDTO;
import booking_site.xws_proj.domain.enums.Role;
import booking_site.xws_proj.domain.querydsl.predicates.MessagePredicates;
import booking_site.xws_proj.repository.AUserRepository;
import booking_site.xws_proj.repository.MessageRepository;
@Service
public class MessageService implements IMessageService {

	@Autowired
	MessageRepository messageRepository;

	@Autowired
	AUserRepository aUserRepository;

	@Override
	public MessageResponseDTO create(MessageRequestDTO requestDto, AUser client) {

		if (client == null) {
			throw new NotLoggedException();
		}

		if (client.getRole() == Role.ADMIN) {
			throw new NotAuthorizedException();
		} // else permission granted
		
		
		Message message = MessageMapper.mapDtoIntoEntity(requestDto, client, aUserRepository.findOne(requestDto.getReceiver_id()));
		if ((message = messageRepository.save(message)) == null) {
			throw new ServerErrorException();
		}

		return MessageMapper.mapEntityIntoDTO(message);
	}

	@Override
	public List<MessageResponseDTO> findAllReceived(AUser client) {

		List<MessageResponseDTO> list = new ArrayList<MessageResponseDTO>();
		Predicate findReceived = MessagePredicates.findReceived(client.getId());
		messageRepository.findAll(findReceived).forEach(e -> list.add(MessageMapper.mapEntityIntoDTO(e)));
		return list;

	}

	@Override
	public List<MessageResponseDTO> findAllSent(AUser client) {

		List<MessageResponseDTO> list = new ArrayList<MessageResponseDTO>();
		Predicate findSent = MessagePredicates.findSent(client.getId());
		messageRepository.findAll(findSent).forEach(e -> list.add(MessageMapper.mapEntityIntoDTO(e)));
		return list;
	}

}
