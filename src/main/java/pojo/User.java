package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {
@Id
@GeneratedValue
	private Integer id;
@Column(name = "email")
	private String email;
@Column(name = "password")
	private String password;
	
	@OneToOne
	private UserProfile profile;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String email, String password, UserProfile profile) {
		super();
		this.email = email;
		this.password = password;
		this.profile = profile;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public UserProfile getProfile() {
		return profile;
	}

	public void setProfile(UserProfile profile) {
		this.profile = profile;
	}
	
	
}
