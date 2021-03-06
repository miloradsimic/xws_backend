package booking_site.xws_proj.domain;

import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.TableGenerator;

import booking_site.xws_proj.domain.enums.Role;

@Entity
// koncept jedna tabela po konkretnoj klasi
@Inheritance(strategy = TABLE_PER_CLASS)
public class AUser {

	@TableGenerator(name = "generator", initialValue = 10000)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	protected Long id;

	@Column(nullable = false, unique = true)
	protected String email;

	@Column(nullable = false)
	protected String password;

	@Column(nullable = false)
	protected String name;

	@Column(name = "role", nullable = false)
	protected Role role;

	@Column(nullable = false)
	protected String address;

	public AUser() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getRoleString() {
		return role.toString();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "AUser [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", role=" + role
				+ ", address=" + address + "]";
	}
	
	

}
