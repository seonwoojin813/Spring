package db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Good {
    
	private int num;
	private String name;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	//매개변수가 없는 생성자
	public Good() {
		super();
	}
	
	//매개변수가 있는 생성자
	public Good(int num, String name) {
		super();
		// this 메소드 안에잇는 변수와 바깥에 있는 변수가 같을 때
		//인스턴스 메소드(멤버 메소드)에서 this를 붙이면 메소드 외부에서 찾기 시작
		//this가 없으면 메소드 내부에서 부터 찾음
		//super가 있으면 상위 클래스에서부터 찾음
		this.num = num;
		this.name = name;
	}
	
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
	@Override
	public String toString() {
		return "Good [num=" + num + ", name=" + name + "]";
	
	}
*/
	
}
