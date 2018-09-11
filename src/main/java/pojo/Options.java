package pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "option")
public class Options {

	
	private Integer id;
	private String text;
	private boolean isCorrect;
	
	Set<Question> questions = new HashSet<>();
	
	public Options() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Options(String text, boolean isCorrect) {
		super();
		this.text = text;
		this.isCorrect = isCorrect;
	}

	public Options(String text, boolean isCorrect, Set<Question> questions) {
		super();
		this.text = text;
		this.isCorrect = isCorrect;
		this.questions = questions;
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
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	@ManyToMany(mappedBy = "options")
	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
}
