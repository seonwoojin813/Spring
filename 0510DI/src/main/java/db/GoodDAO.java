package db;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


import org.springframework.stereotype.Repository;


@Repository
public class GoodDAO {
	
	@PostConstruct
	public void 초기화메소드() {
		System.out.println("객체가 생성된 후 호출되는 메소드");
	}
	
	@PreDestroy
	public void 소멸될때호출되는메소드() {
		System.out.println("객체가 소멸되기 직전에 호출되는 메소드");
	}



	public Good get() {
   Good good  = new Good();
   good.setNum(1);
   good.setName("축구");
   
   return good;
}
}
