package booking_site.xws_proj.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.util.concurrent.Service.State;

import booking_site.xws_proj.AppUtils;
import booking_site.xws_proj.controller.exceptions.AlreadyExistsException;
import booking_site.xws_proj.controller.exceptions.NotAuthorizedException;
import booking_site.xws_proj.controller.exceptions.NotLoggedException;
import booking_site.xws_proj.domain.AUser;
import booking_site.xws_proj.domain.Comment;
import booking_site.xws_proj.domain.User;
import booking_site.xws_proj.domain.dto.mappper.CommentMapper;
import booking_site.xws_proj.domain.dto.request.CommentRequestDTO;
import booking_site.xws_proj.domain.dto.response.CommentResponseDTO;
import booking_site.xws_proj.domain.enums.Role;
import booking_site.xws_proj.domain.enums.Status;
import booking_site.xws_proj.repository.AUserRepository;
import booking_site.xws_proj.repository.CommentRepository;
import booking_site.xws_proj.service.IAccommodationService;
import booking_site.xws_proj.service.ICommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private AUserRepository aUserRepository;
	@Autowired
	private ICommentService commentService;
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private IAccommodationService accommodationService;

	/*
	 * Create
	 * 
	 * @return UserResponseDTO
	 */
	@RequestMapping(path = "/comment", method = RequestMethod.POST)
	public ResponseEntity<CommentResponseDTO> create(HttpServletRequest request,
			@RequestBody CommentRequestDTO requestDto) {

		AUser user;

		String encoded = request.getHeader("Authorization");
		String username = AppUtils.getUsernameFromBasic(encoded);
		String password = AppUtils.getPasswordFromBasic(encoded);
		if ((user = aUserRepository.findByEmailAndPassword(username, password)) == null) {
			throw new NotLoggedException();
		}
		if (user.getRole() != Role.USER) {
			throw new NotAuthorizedException();
		} // else permission granted

		Comment comment;

		comment = commentService.createComment(new Comment((User) user,
				accommodationService.find(requestDto.getAccommodation_id()), requestDto.getText()));

		return new ResponseEntity<CommentResponseDTO>(CommentMapper.mapEntityIntoDTO(comment), HttpStatus.CREATED);
	}

	/*
	 * Read one
	 */
	@RequestMapping(path = "/comment/{id}", method = RequestMethod.GET)
	public ResponseEntity<CommentResponseDTO> readOne(@PathVariable("id") Long id) {
		return new ResponseEntity<CommentResponseDTO>(CommentMapper.mapEntityIntoDTO(commentRepository.findOne(id)),
				HttpStatus.OK);
	}

	/*
	 * Read all for agent
	 */
	@RequestMapping(path = "/comments_for_approval", method = RequestMethod.GET)
	public ResponseEntity<List<CommentResponseDTO>> readAllUnapproved() {
		List<CommentResponseDTO> list = new ArrayList<CommentResponseDTO>();
		commentService.findAllNotReviewed().forEach(e -> list.add(CommentMapper.mapEntityIntoDTO(e)));
		return new ResponseEntity<List<CommentResponseDTO>>(list, HttpStatus.OK);
	}

	/*
	 * Read all for accommodation
	 */
	@RequestMapping(path = "/comments_for_accommodation/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<CommentResponseDTO>> readAllComments(@PathVariable("id") Long id) {
		List<CommentResponseDTO> list = new ArrayList<CommentResponseDTO>();
		commentService.findAllForAccommodation(id).forEach(e -> list.add(CommentMapper.mapEntityIntoDTO(e)));
		return new ResponseEntity<List<CommentResponseDTO>>(list, HttpStatus.OK);
	}

	/*
	 * Admin approves comment
	 */
	@RequestMapping(path = "/approve/{id}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> approveComment(HttpServletRequest request, @PathVariable("id") Long id) {

		AUser admin;

		String encoded = request.getHeader("Authorization");
		String username = AppUtils.getUsernameFromBasic(encoded);
		String password = AppUtils.getPasswordFromBasic(encoded);
		if ((admin = aUserRepository.findByEmailAndPassword(username, password)) == null) {
			throw new NotLoggedException();
		}
		if (admin.getRole() != Role.ADMIN) {
			throw new NotAuthorizedException();
		} // else permission granted
		
		
		return new ResponseEntity<Boolean>(commentService.changeStatus(id, Status.APPROVED), HttpStatus.OK);
	}
	
	/*
	 * Admin disapproves comment
	 */
	@RequestMapping(path = "/disapprove/{id}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> disapproveComment(HttpServletRequest request, @PathVariable("id") Long id) {

		AUser admin;

		String encoded = request.getHeader("Authorization");
		String username = AppUtils.getUsernameFromBasic(encoded);
		String password = AppUtils.getPasswordFromBasic(encoded);
		if ((admin = aUserRepository.findByEmailAndPassword(username, password)) == null) {
			throw new NotLoggedException();
		}
		if (admin.getRole() != Role.ADMIN) {
			throw new NotAuthorizedException();
		} // else permission granted
		
		
		return new ResponseEntity<Boolean>(commentService.changeStatus(id, Status.DISAPPROVED), HttpStatus.OK);
	}
}




















