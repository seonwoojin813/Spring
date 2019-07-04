package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import db.GoodService;
import db.Good;

public class Main {

	public static void main(String[] args) {
		try(GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");){
			/*
			Good good = context.getBean("g1", Good.class);
			
			//매개변수가 없는 생성자를 이용했으므로 인스턴스 변수가 기본 값을 가지고 있습니다.
			System.out.println(good);
			
			good =  context.getBean("g2", Good.class);
			System.out.println(good);
			
			good =  context.getBean("g3", Good.class);
			System.out.println(good);

			good =  context.getBean("g4", Good.class);
			System.out.println(good);
		
		   good =  context.getBean("g5", Good.class);
			System.out.println(good);
						
			good =  context.getBean("g6", Good.class);
			System.out.println(good);
			*/
	       
			/*
			CollectionBean bean = context.getBean("collectionBean", CollectionBean.class);
			System.out.println(bean.getList());
			System.out.println(bean.getSet());
			System.out.println(bean.getMap());
			*/
			
			
		 GoodService goodService = context.getBean("goodService", GoodService.class);
		 Good good = goodService.get();
		 System.out.println(good);
			
		}catch(Exception e) {
			System.out.println("예외:" + e.getMessage());
			e.printStackTrace();
		}
	}
}

