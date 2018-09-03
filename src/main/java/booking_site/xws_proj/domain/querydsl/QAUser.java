package booking_site.xws_proj.domain.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import booking_site.xws_proj.domain.AUser;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAUser is a Querydsl query type for AUser
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAUser extends EntityPathBase<AUser> {

    private static final long serialVersionUID = 145232647L;

    public static final QAUser aUser = new QAUser("aUser");

    public final StringPath address = createString("address");

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final EnumPath<booking_site.xws_proj.domain.enums.Role> role = createEnum("role", booking_site.xws_proj.domain.enums.Role.class);

    public QAUser(String variable) {
        super(AUser.class, forVariable(variable));
    }

    public QAUser(Path<? extends AUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAUser(PathMetadata metadata) {
        super(AUser.class, metadata);
    }

}

