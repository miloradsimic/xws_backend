package booking_site.xws_proj.domain.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

import booking_site.xws_proj.domain.QAClient;
import booking_site.xws_proj.domain.QAccommodation;
import booking_site.xws_proj.domain.Reservation;


/**
 * QReservation is a Querydsl query type for Reservation
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReservation extends EntityPathBase<Reservation> {

    private static final long serialVersionUID = 1779005127L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReservation reservation = new QReservation("reservation");

    public final QAccommodation accommodation;

    public final QAClient client;

    public final DateTimePath<java.util.Date> endTime = createDateTime("endTime", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> startTime = createDateTime("startTime", java.util.Date.class);

    public final EnumPath<booking_site.xws_proj.domain.enums.Status> status = createEnum("status", booking_site.xws_proj.domain.enums.Status.class);

    public QReservation(String variable) {
        this(Reservation.class, forVariable(variable), INITS);
    }

    public QReservation(Path<? extends Reservation> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReservation(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReservation(PathMetadata metadata, PathInits inits) {
        this(Reservation.class, metadata, inits);
    }

    public QReservation(Class<? extends Reservation> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.accommodation = inits.isInitialized("accommodation") ? new QAccommodation(forProperty("accommodation")) : null;
        this.client = inits.isInitialized("client") ? new QAClient(forProperty("client")) : null;
    }

}

