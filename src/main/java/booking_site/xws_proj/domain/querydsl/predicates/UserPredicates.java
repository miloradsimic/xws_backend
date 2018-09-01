package booking_site.xws_proj.domain.querydsl.predicates;

import com.querydsl.core.types.Predicate;

import booking_site.xws_proj.domain.QAUser;
import booking_site.xws_proj.domain.enums.Role;
import booking_site.xws_proj.domain.querydsl.QUser;

public class UserPredicates {
	private UserPredicates() {
	}

	public static Predicate findAll() {
		return QUser.user.deleted.isFalse();
	}

	public static Predicate isLogged(String email, String password) {
		return QUser.user.email.eq(email).and(QUser.user.password.eq(password)).and(QUser.user.active.eq(true))
				.and(QUser.user.deleted.eq(false));
	}

	public static Predicate findAgent(Long id) {
		return QAUser.aUser.id.eq(id).and(QAUser.aUser.role.eq(Role.AGENT));
	}

	public static Predicate findAgents() {
		return QAUser.aUser.role.eq(Role.AGENT);
	}

}
