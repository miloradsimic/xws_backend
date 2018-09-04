package booking_site.xws_proj.domain.querydsl.predicates;

import com.querydsl.core.types.Predicate;

import booking_site.xws_proj.domain.querydsl.QMessage;

public class MessagePredicates {

	public static Predicate findReceived(Long id) {
		return QMessage.message.receiver.id.eq(id);
	}

	public static Predicate findSent(Long id) {
		return QMessage.message.sender.id.eq(id);
	}

}
