package booking_site.xws_proj.domain;

import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
@Inheritance(strategy = TABLE_PER_CLASS)
public class AClient extends AUser {

}
