package booking_site.xws_proj.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import booking_site.xws_proj.domain.Message;

public interface MessageRepository extends CrudRepository<Message, Long>, QueryDslPredicateExecutor<Message> {

}