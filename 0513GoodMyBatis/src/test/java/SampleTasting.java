import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import good.dao.GoodDAO;
//import good.domain.Good;

//스프링의 테스트  클래스로 설정
@RunWith(SpringJUnit4ClassRunner.class)
//스프링 설정 파일을 실행하기 위한 어노테이션 
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SampleTasting {

	@Autowired
	private GoodDAO goodDao;
	
	@Test
	public void daoTest() {
		/*
		System.out.println(goodDao.codeSearch(1));
		System.out.println(goodDao.codeSearch(7));
		*/
		
		/*
		 // 삽입 
	   Good good = new Good();
	   good.setCode(7);
	   good.setName("무화과");
	   good.setManufacture("전남 영암");
	   good.setPrice(3000);
	   
	   int r = goodDao.insertGood(good);
	   //삽입 및 삭제 갱신은 반드시 결과만 확인하지 말고 
	   //데이터 베이스 확인
	   System.out.println(r);
	   */
		
		/*
		   //수정
		   Good good = new Good();
		   good.setCode(7);
		   good.setName("pear");
		   good.setManufacture("korea");
		   good.setPrice(3000);
		   
		   int r = goodDao.updateGood(good);
		   //삽입 및 삭제 갱신은 반드시 결과만 확인하지 말고 
		   //데이터 베이스 확인
		   System.out.println(r);
	   */
	      //삭제
		  int r = goodDao.deleteGood(7);
		   //삽입 및 삭제 갱신은 반드시 결과만 확인하지 말고 
		   //데이터 베이스 확인
		   System.out.println(r);
		
		
	}
}
