package ioc;

public class Player {
   private int num;
   private String name;
   private String events;
   
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEvents() {
	return events;
}
public void setEvents(String events) {
	this.events = events;
}
@Override
public String toString() {
	return "Player [num=" + num + ", name=" + name + ", events=" + events + "]";
}
   
}
