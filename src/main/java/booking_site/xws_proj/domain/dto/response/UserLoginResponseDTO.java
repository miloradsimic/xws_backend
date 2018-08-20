package booking_site.xws_proj.domain.dto.response;

public class UserLoginResponseDTO extends ResponseErrorHandler {
	
	public long id;
	public String email;
	public String name;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public UserLoginResponseDTO() {}
	
	
}
