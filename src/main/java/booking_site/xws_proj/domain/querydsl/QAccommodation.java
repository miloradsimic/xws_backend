package booking_site.xws_proj.domain.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import booking_site.xws_proj.domain.Accommodation;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAccommodation is a Querydsl query type for Accommodation
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAccommodation extends EntityPathBase<Accommodation> {

    private static final long serialVersionUID = -1600266099L;

    public static final QAccommodation accommodation = new QAccommodation("accommodation");

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath id_agent = createString("id_agent");

    public final NumberPath<Double> price = createNumber("price", Double.class);

    public QAccommodation(String variable) {
        super(Accommodation.class, forVariable(variable));
    }

    public QAccommodation(Path<? extends Accommodation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccommodation(PathMetadata metadata) {
        super(Accommodation.class, metadata);
    }

}

