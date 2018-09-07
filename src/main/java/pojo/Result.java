package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "results")
public class Result {

	private Integer id;
	private String duration;
	private Integer questionsAttempted;
	private Integer questionsNotAttempted;
	private Integer marks;
	private String time;

	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Result(String duration, Integer questionsAttempted, Integer questionsNotAttempted, Integer marks,
			String time) {
		super();
		this.duration = duration;
		this.questionsAttempted = questionsAttempted;
		this.questionsNotAttempted = questionsNotAttempted;
		this.marks = marks;
		this.time = time;
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Integer getQuestionsAttempted() {
		return questionsAttempted;
	}

	public void setQuestionsAttempted(Integer questionsAttempted) {
		this.questionsAttempted = questionsAttempted;
	}

	public Integer getQuestionsNotAttempted() {
		return questionsNotAttempted;
	}

	public void setQuestionsNotAttempted(Integer questionsNotAttempted) {
		this.questionsNotAttempted = questionsNotAttempted;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
