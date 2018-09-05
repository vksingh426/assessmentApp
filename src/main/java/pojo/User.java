package pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "USER")
public class User {

	private Integer id;
	private String email;
	private String password;
	
	@OneToOne(mappedBy = "phone",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
	private UserProfile profile;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

@GenericGenerator(name = "generator", strategy = "increment")
@Id
@GeneratedValue(generator = "generator")
@Column(name = "id", unique = true, nullable = false)
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
