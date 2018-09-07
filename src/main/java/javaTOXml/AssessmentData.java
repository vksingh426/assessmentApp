package javaTOXml;

import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AssessmentData {

	private Integer id;
	private String role;
	private String title;
	private String date;
	private String description;
	private Set<QuestionData> questionDatas = new HashSet<>();
	
	public AssessmentData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AssessmentData(Integer id, String role, String title, String date, String description) {
		super();
		this.id = id;
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
	@XmlAttribute
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
	public Set<QuestionData> getQuestionDatas() {
		return questionDatas;
	}
	public void setQuestionDatas(Set<QuestionData> questionDatas) {
		this.questionDatas = questionDatas;
	}
	
	
}
