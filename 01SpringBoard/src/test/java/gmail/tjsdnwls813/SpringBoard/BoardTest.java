package gmail.tjsdnwls813.SpringBoard;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gmail.tjsdnwls813.SpringBoard.service.UserService;

//Spring 테스트 클래스를 만들어주는 어노테이션 설정
@RunWith(SpringJUnit4ClassRunner.class)
//Spring 설정 파일을 실행하기 위한 설정
@ContextConfiguration(locations= {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class BoardTest {
   //테스트 할 객체 주입
	@Autowired
	private DataSource dataSource;
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private UserService userService;
	@Test
	public void emailcheck() {
		System.out.println(
				userService.emailcheck("tjsdnwls813@gmail.com"));
		System.out.println(
				userService.emailcheck("tjsdnwls814@gmail.com"));
	}
	
	@Test
	public void mybatisTest() {
		System.out.println("mybatis:" + sqlSession);
	}
	
	//테스트 할 메소드
	@Test
	 public void conTest() {
		try(Connection con = dataSource.getConnection()){
			System.out.println("con:" + con);
		}catch(Exception e) {
			System.out.println("예외:" + e.getMessage());
		}
	}  
}
