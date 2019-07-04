//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import mybatis.dao.SingerDAO;
import mybatis.dao.TransactionDao;
import mybatis.domain.Singer;

public class Main {

	
	public static void main(String[] args) {
		
		//SpringBeanconfiguration 파일을 이용하는 경우의 context
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext(
						"classpath:applicationContext.xml");
		
		
		/*
		//어노테이션으로 만들어진 설정 파일 불러기
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(RootConfig.class);
		*/
		
		//SingerDAO dao = context.getBean(SingerDAO.class);
		//System.out.println(dao.singerList());
       
		
		TransactionDao dao = context.getBean(TransactionDao.class);
		dao.insert();
		
		
		//dao.singerList();
		
		/*
		Singer singer = new Singer();
		singer.setName("여자친구");
		singer.setMajorsong("여자친구");
		dao.singerInsert(singer);
		*/
			
		context.close();
	
	}

}
