package booking_site.xws_proj.domain.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import booking_site.xws_proj.domain.AUser;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserAbstr is a Querydsl query type for UserAbstr
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserAbstr extends EntityPathBase<AUser> {

    private static final long serialVersionUID = 1905832736L;

    public static final QUserAbstr userAbstr = new QUserAbstr("userAbstr");

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final EnumPath<booking_site.xws_proj.domain.enums.Role> role = createEnum("role", booking_site.xws_proj.domain.enums.Role.class);

    public QUserAbstr(String variable) {
        super(AUser.class, forVariable(variable));
    }

    public QUserAbstr(Path<? extends AUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserAbstr(PathMetadata metadata) {
        super(AUser.class, metadata);
    }

}

