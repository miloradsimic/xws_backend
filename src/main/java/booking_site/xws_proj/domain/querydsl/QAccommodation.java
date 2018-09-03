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

    public final StringPath address = createString("address");

    public final NumberPath<Long> agentId = createNumber("agentId", Long.class);

    public final BooleanPath breakfast = createBoolean("breakfast");

    public final NumberPath<Integer> category = createNumber("category", Integer.class);

    public final NumberPath<Double> dailyPrice = createNumber("dailyPrice", Double.class);

    public final StringPath description = createString("description");

    public final BooleanPath fullBoard = createBoolean("fullBoard");

    public final BooleanPath halfBoard = createBoolean("halfBoard");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageUri = createString("imageUri");

    public final BooleanPath kitchen = createBoolean("kitchen");

    public final BooleanPath parking = createBoolean("parking");

    public final BooleanPath privateBathroom = createBoolean("privateBathroom");

    public final BooleanPath tv = createBoolean("tv");

    public final EnumPath<booking_site.xws_proj.domain.enums.AccommodationType> type = createEnum("type", booking_site.xws_proj.domain.enums.AccommodationType.class);

    public final BooleanPath wifi = createBoolean("wifi");

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

