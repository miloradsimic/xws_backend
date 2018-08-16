package booking_site.xws_proj.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import booking_site.xws_proj.AppUtils;
import booking_site.xws_proj.domain.Reservation;
import booking_site.xws_proj.domain.User;
import booking_site.xws_proj.dto.request.ReservationDTO;
import booking_site.xws_proj.repository.UserRepository;
import booking_site.xws_proj.service.UserService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
    private UserRepository repository;

	@Autowired
	private UserService service;
	
	@RequestMapping(path="/reservation", method = RequestMethod.POST)
	public HashMap<String, Object> makeAReservation(@RequestHeader("Authorization") String encoded, @RequestBody ReservationDTO reservationDTO) {
		HashMap<String,Object> retVal = new HashMap<>();
		
		
		
		String username = AppUtils.getUsernameFromBasic(encoded);
		String password = AppUtils.getPasswordFromBasic(encoded);

		User loggedUser = this.service.findByEmailAndPasswordLogin(username, password);

		if(loggedUser == null) {
			retVal.put("message", "Unssuccesful login! / Unauthorized");
			return retVal;
		}//else successful login
		
		
		
		
		//TODO: DO SOME MAGIC!!!
		//try to reserve, receive feedback message or error, forward to client through retVal
		
		Reservation reservation = new Reservation();
		reservation.setEmail("email@email.com");
		reservation.setId(1000);
		reservation.setEmail_agent("email@email.com2");
		reservation.setTime(new Date());
		retVal.put("message", "Successfully reserved! (Dummy message!)");
		retVal.put("data", reservation);
		
		
		return retVal;
	}
	
}
