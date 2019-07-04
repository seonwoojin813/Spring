package di;

public class Player {
   private Integer num;
   private String name;
   
 //매개변수가 없는 생성자 
public Player() {
	super();
}

//매개변수가 2개인 생성자
public Player(Integer num, String name) {
	super();
	this.num = num;
	this.name = name;
}

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
