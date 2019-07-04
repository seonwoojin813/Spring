package di;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {
	//<>을 Generic 또는 템플릿 프로그래밍이라고 하는데
	//미리 자료형을 결정하지 않고 객체가 만들어질 때 자료형을 결정하기위한 
	//프로그래밍 방식
	//알고리즘은 동일한데 대입되는 데이터에 따라 매번 다시 메소들을 구현하는것이 번거로워서 사
private List<String> list;
private Set<String> set;
private Map<String, Object>map;
private Properties prop;

public List<String> getList() {
	return list;
}
public void setList(List<String> list) {
	this.list = list;
}
public Set<String> getSet() {
	return set;
}
public void setSet(Set<String> set) {
	this.set = set;
}
public Map<String, Object> getMap() {
	return map;
}
public void setMap(Map<String, Object> map) {
	this.map = map;
}
public Properties getProp() {
	return prop;
}
public void setProp(Properties prop) {
	this.prop = prop;
}
@Override
public String toString() {
	return "CollectionBean []";
}

}
