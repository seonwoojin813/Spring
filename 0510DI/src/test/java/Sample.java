

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import db.Good;
import db.GoodService;

//스프링의 테스트  클래스로 설정
@RunWith(SpringJUnit4ClassRunner.class)
//스프링 설정 파일을 실행하기 위한 어노테이션 
@ContextConfiguration("classpath:applicationContext.xml")
public class Sample {
  //동일한 자료형의 객체가 있으면 자동으로 주입해주는 어노테이
	@Autowired
	private GoodService goodService;
	
	//테스트를 위한 메소드를 설정하기 위한 어노테이션
	@Test
	public void testing() {
		Good good = goodService.get();
		System.out.println(good);
	}
}
