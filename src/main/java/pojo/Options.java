package pojo;

public class Options {

	private Integer id;
	private String text;
	private boolean isCorrect;
	public Options() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Options(String text, boolean isCorrect) {
		super();
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
