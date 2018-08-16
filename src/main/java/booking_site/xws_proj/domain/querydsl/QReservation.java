package booking_site.xws_proj.domain.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import booking_site.xws_proj.domain.Reservation;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QReservation is a Querydsl query type for Reservation
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReservation extends EntityPathBase<Reservation> {

    private static final long serialVersionUID = 1779005127L;

    public static final QReservation reservation = new QReservation("reservation");

    public final StringPath email = createString("email");

    public final StringPath email_agent = createString("email_agent");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> id_accomomdation = createNumber("id_accomomdation", Long.class);

    public final DateTimePath<java.util.Date> time = createDateTime("time", java.util.Date.class);

    public QReservation(String variable) {
        super(Reservation.class, forVariable(variable));
    }

    public QReservation(Path<? extends Reservation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReservation(PathMetadata metadata) {
        super(Reservation.class, metadata);
    }

}

