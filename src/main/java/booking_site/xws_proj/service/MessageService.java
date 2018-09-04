package booking_site.xws_proj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;

import booking_site.xws_proj.controller.exceptions.NotAuthorizedException;
import booking_site.xws_proj.controller.exceptions.NotLoggedException;
import booking_site.xws_proj.controller.exceptions.ServerErrorException;
import booking_site.xws_proj.domain.AClient;
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
	public MessageResponseDTO create(MessageRequestDTO requestDto, AUser sender) {

		if (sender == null) {
			throw new NotLoggedException();
		}

		if (sender.getRole() == Role.ADMIN) {
			throw new NotAuthorizedException();
		} // else permission granted
		
		MessageResponseDTO responseDTO;
		Message message2;
		AUser receiver = aUserRepository.findOne(requestDto.getReceiver_id());
		
		System.out.println("sender" + sender.toString() );

		System.out.println("receiver "  +receiver.toString() );
//		
//		AClient sender = new AClient(client);
//		AClient receiver2 = new AClient(receiver);
		
		Message message = MessageMapper.mapDtoIntoEntity(requestDto, (AClient)sender, (AClient)receiver);
		if(message == null) {
			throw new ServerErrorException();
		}
		if ((message2 = messageRepository.save(message)) == null) {
			throw new ServerErrorException();
		}
		System.out.println("message:     " + message2.toString());

		return MessageMapper.mapEntityIntoDTO(message2);
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
