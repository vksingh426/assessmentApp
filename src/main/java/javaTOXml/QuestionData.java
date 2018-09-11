package javaTOXml;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

public class QuestionData {
	
	private Integer id;
	private String text;
	private String time;
	private Integer marks;
	private boolean isAttempted;
		
	Set<OptionData> optionDatas = new HashSet<>();

	public QuestionData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionData(Integer id, String text, String time, Integer marks, boolean isAttempted,
			Set<OptionData> optionDatas) {
		super();
		this.id = id;
		this.text = text;
		this.time = time;
		this.marks = marks;
		this.isAttempted = isAttempted;
		this.optionDatas = optionDatas;
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

	public Set<OptionData> getOptionDatas() {
		return optionDatas;
	}

	public void setOptionDatas(Set<OptionData> optionDatas) {
		this.optionDatas = optionDatas;
	}
	{
	for (int j=1;j<=4;j++){
    	OptionData option2 = new OptionData();
    		option2.setId(j);
    		option2.setText("120 metres");
    		if(j==2){
    		option2.setCorrect(true);
    		}
    		else{
    			option2.setCorrect(false);
    		}
    		optionDatas.add(option2);
    	}
	
		}
	
}
