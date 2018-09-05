package pojo;

import com.sun.jmx.snmp.Timestamp;

public class Result {
	
	private Timestamp duration;
	private Integer questionsAttempted;
	private String questionsNotAttempted;
	private Integer marks;
	private String time;
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Result(Timestamp duration, Integer questionsAttempted, String questionsNotAttempted, Integer marks,
			String time) {
		super();
		this.duration = duration;
		this.questionsAttempted = questionsAttempted;
		this.questionsNotAttempted = questionsNotAttempted;
		this.marks = marks;
		this.time = time;
	}
	public Timestamp getDuration() {
		return duration;
	}
	public void setDuration(Timestamp duration) {
		this.duration = duration;
	}
	public Integer getQuestionsAttempted() {
		return questionsAttempted;
	}
	public void setQuestionsAttempted(Integer questionsAttempted) {
		this.questionsAttempted = questionsAttempted;
	}
	public String getQuestionsNotAttempted() {
		return questionsNotAttempted;
	}
	public void setQuestionsNotAttempted(String questionsNotAttempted) {
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
