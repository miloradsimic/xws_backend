package booking_site.xws_proj.domain.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import booking_site.xws_proj.domain.AClient;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAClient is a Querydsl query type for AClient
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAClient extends EntityPathBase<AClient> {

    private static final long serialVersionUID = 1607941127L;

    public static final QAClient aClient = new QAClient("aClient");

    public final QAUser _super = new QAUser(this);

    //inherited
    public final StringPath address = _super.address;

    //inherited
    public final StringPath email = _super.email;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath name = _super.name;

    //inherited
    public final StringPath password = _super.password;

    //inherited
    public final EnumPath<booking_site.xws_proj.domain.enums.Role> role = _super.role;

    public QAClient(String variable) {
        super(AClient.class, forVariable(variable));
    }

    public QAClient(Path<? extends AClient> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAClient(PathMetadata metadata) {
        super(AClient.class, metadata);
    }

}

