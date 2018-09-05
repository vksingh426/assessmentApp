package pojo;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.jmx.snmp.Timestamp;
@Entity
@Table(name="ASSESSMENT")
public class Assessment {
	@Id
	@GeneratedValue
	private Integer id;
	private String role;
	private String title;
	private Timestamp date;
	private String description;
	@OneToMany
	private ArrayList<User> user = new ArrayList<>();
	
	public Assessment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Assessment(String role, String title, Timestamp date, String description) {
		super();
		this.role = role;
		this.title = title;
		this.date = date;
		this.description = description;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<User> getUser() {
		return user;
	}
	public void setUser(ArrayList<User> user) {
		this.user = user;
	}
	
	

}
