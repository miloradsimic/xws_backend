package booking_site.xws_proj.domain.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import booking_site.xws_proj.domain.Agent;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAgent is a Querydsl query type for Agent
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAgent extends EntityPathBase<Agent> {

    private static final long serialVersionUID = 145755712L;

    public static final QAgent agent = new QAgent("agent");

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public QAgent(String variable) {
        super(Agent.class, forVariable(variable));
    }

    public QAgent(Path<? extends Agent> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAgent(PathMetadata metadata) {
        super(Agent.class, metadata);
    }

}

