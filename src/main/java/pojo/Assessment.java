package pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "ASSESSMENT")
public class Assessment {
	
	private Integer id;
	private String role;
	private String title;
	private String date;
	private String description;

	private Set<Question> questionList = new HashSet<>();
	private User user;
	
	public Assessment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Assessment(String role, String title, String date, String description) {
		super();
		this.role = role;
		this.title = title;
		this.date = date;
		this.description = description;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	public Set<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(Set<Question> questionList) {
		this.questionList = questionList;
	}

	public Assessment(Set<Question> questionList, User user) {
		super();
		this.questionList = questionList;
		this.user = user;
	}
	

}
