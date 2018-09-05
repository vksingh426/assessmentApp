package pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USER_PROFILE")
public class UserProfile {

	private String name;
	private String DOB;
	private Integer age;
	private String address;
	


	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserProfile(String name, String dOB, Integer age, String address) {
		super();
		this.name = name;
		DOB = dOB;
		this.age = age;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
