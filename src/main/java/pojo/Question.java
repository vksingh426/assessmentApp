package pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "QUESTION")
public class Question {
	
	private Integer id;
	@Column(name = "text")
	private String text;
	@Column(name = "time")
	private String time;
	@Column(name = "marks")
	private Integer marks;
	@Column(name = "isAttempted")
	private boolean isAttempted;

	
	private Set<Assessment> assessmentList = new HashSet<>();

	private Set<Options> options = new HashSet<>();
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(String text, String time, Integer marks, boolean isAttempted,
			Set<Assessment> assessmentList) {
		super();
		this.text = text;
		this.time = time;
		this.marks = marks;
		this.isAttempted = isAttempted;
		this.assessmentList = assessmentList;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public boolean isAttempted() {
		return isAttempted;
	}

	public void setAttempted(boolean isAttempted) {
		this.isAttempted = isAttempted;
	}
	
	
	@ManyToMany(mappedBy = "questionList")
	public Set<Assessment> getAssessmentList() {
		return assessmentList;
	}

	public void setAssessmentList(Set<Assessment> assessmentList) {
		this.assessmentList = assessmentList;
	}
	
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	public Set<Options> getOptions() {
		return options;
	}

	public void setOptions(Set<Options> options) {
		this.options = options;
	}
	

}
