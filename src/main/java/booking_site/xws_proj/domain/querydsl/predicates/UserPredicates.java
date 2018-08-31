package booking_site.xws_proj.domain.querydsl.predicates;

import com.querydsl.core.types.Predicate;

import booking_site.xws_proj.domain.querydsl.QUser;

public class UserPredicates {
	private UserPredicates() {
	}
	
	public static Predicate findAll() {
		return QUser.user.deleted.isFalse();
	}
}

