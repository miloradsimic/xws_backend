package booking_site.xws_proj.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import booking_site.xws_proj.domain.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long>, QueryDslPredicateExecutor<Comment> {

}