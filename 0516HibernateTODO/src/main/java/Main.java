import org.springframework.context.support.GenericXmlApplicationContext;

import hibernate.dao.TODODAO;
//import hibernate.domain.TODO;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		TODODAO dao =  context.getBean(TODODAO.class);
		
		/*
		TODO todo = new TODO();
		todo.setNum(5);
		todo.setTitle("HAZARD");
		todo.setContent("CHELSEA");
		todo.setDate("19910107");
		

		//System.out.println(dao.listTODO());
		*/
		
		//1개를 가져올 때는 데이터가 없을 때 
		System.out.println(dao.get(1));
		System.out.println(dao.get(6));
		
		
		context.close();

	}
	
}
