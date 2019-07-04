package kr.co.pk;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.pk.domain.Item;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public class MybatisTesting {
	//여기서 테스트가 가능하도록 하기 위해서
	//Service 클래스의 매개변수를 HttpServletRequest를 
	//사용하지 않을려고 합니다.

	  @Autowired
	  private SqlSession sqlSession;
	  
	  @Test
	  public void testing() {
		 // System.out.println(sqlSession);
		 // System.out.println(sqlSession.selectList("itemMapper.allItem"));
		  
		  Item item = sqlSession.selectOne("itemMapper.getItem", 1);
		  System.out.println(item);
	  }
	  
}
