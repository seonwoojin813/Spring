package di;

public class Player {

 //매개변수가 없는 것
	public Player() {
		super();
	}
	
	//매개변수 있는것
	public Player(Integer num, String name) {
	super();
	this.num = num;
	this.name = name;
}

	private Integer num;
	private String name;
	
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Player [num=" + num + ", name=" + name + "]";
	}
}
