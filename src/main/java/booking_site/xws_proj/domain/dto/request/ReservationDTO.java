package booking_site.xws_proj.dto.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservationDTO {

    public long user_id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    public Date date;
    public int duration; 
    public long id_accommodation;
    
    
}
