package booking_site.xws_proj.controller;

import java.util.List;

import javax.annotation.processing.Messager;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import booking_site.xws_proj.AppUtils;
import booking_site.xws_proj.controller.exceptions.NotAuthorizedException;
import booking_site.xws_proj.controller.exceptions.NotLoggedException;
import booking_site.xws_proj.domain.AUser;
import booking_site.xws_proj.domain.Comment;
import booking_site.xws_proj.domain.Message;
import booking_site.xws_proj.domain.User;
import booking_site.xws_proj.domain.dto.mappper.CommentMapper;
import booking_site.xws_proj.domain.dto.request.CommentRequestDTO;
import booking_site.xws_proj.domain.dto.request.MessageRequestDTO;
import booking_site.xws_proj.domain.dto.response.CommentResponseDTO;
import booking_site.xws_proj.domain.dto.response.MessageResponseDTO;
import booking_site.xws_proj.domain.enums.Role;
import booking_site.xws_proj.repository.AUserRepository;
import booking_site.xws_proj.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private AUserRepository aUserRepository;
	
	
	/*
	 * Create / Send message
	 * 
	 * @return MessageResponseDTO
	 */
	@RequestMapping(path = "/message", method = RequestMethod.POST)
	public ResponseEntity<MessageResponseDTO> create(HttpServletRequest request,
			@RequestBody MessageRequestDTO requestDto) {

		AUser aUser;

		String encoded = request.getHeader("Authorization");
		String username = AppUtils.getUsernameFromBasic(encoded);
		String password = AppUtils.getPasswordFromBasic(encoded);
		if ((aUser = aUserRepository.findByEmailAndPassword(username, password)) == null) {
			throw new NotLoggedException();
		}
		
		MessageResponseDTO responseDTO = messageService.create(requestDto, aUser);
		
		
		return new ResponseEntity<MessageResponseDTO>(responseDTO, HttpStatus.CREATED);
	}

	/*
	 * Get all sent messages
	 * 
	 * @return List<MessageResponseDTO>
	 */
	@RequestMapping(path = "/all_sent", method = RequestMethod.GET)
	public ResponseEntity<List<MessageResponseDTO>> findAllSent(HttpServletRequest request) {

		AUser aUser;

		String encoded = request.getHeader("Authorization");
		String username = AppUtils.getUsernameFromBasic(encoded);
		String password = AppUtils.getPasswordFromBasic(encoded);
		if ((aUser = aUserRepository.findByEmailAndPassword(username, password)) == null) {
			throw new NotLoggedException();
		}
		
		List<MessageResponseDTO> responseList = messageService.findAllSent(aUser);
		
		
		return new ResponseEntity<List<MessageResponseDTO>>(responseList, HttpStatus.OK);
	}

	/*
	 * Get all received messages
	 * 
	 * @return List<MessageResponseDTO>
	 */
	@RequestMapping(path = "/all_received", method = RequestMethod.GET)
	public ResponseEntity<List<MessageResponseDTO>> findAllReceived(HttpServletRequest request) {

		AUser aUser;

		String encoded = request.getHeader("Authorization");
		String username = AppUtils.getUsernameFromBasic(encoded);
		String password = AppUtils.getPasswordFromBasic(encoded);
		if ((aUser = aUserRepository.findByEmailAndPassword(username, password)) == null) {
			throw new NotLoggedException();
		}
		
		List<MessageResponseDTO> responseList = messageService.findAllReceived(aUser);
		
		
		return new ResponseEntity<List<MessageResponseDTO>>(responseList, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
