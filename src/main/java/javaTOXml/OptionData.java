package javaTOXml;

public class OptionData {
	
	private Integer id;
	private String text; 
	private boolean isCorrect;
	public OptionData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OptionData(Integer id, String text, boolean isCorrect) {
		super();
		this.id = id;
		this.text = text;
		this.isCorrect = isCorrect;
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
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	

}
