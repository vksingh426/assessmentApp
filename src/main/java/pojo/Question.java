package pojo;

import java.sql.Time;

import com.sun.jmx.snmp.Timestamp;

public class Question {
	
	private Integer id;
	private String text;
	private String time;
	private Integer marks;
	private boolean isAttempted;
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question(String text, String time, Integer marks, boolean isAttempted) {
		super();
		this.text = text;
		this.time = time;
		this.marks = marks;
		this.isAttempted = isAttempted;
	}
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
	
}
