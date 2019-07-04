package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import di.Player;

public class Main {

	public static void main(String[] args) {
		try(
				//xml 설정 파일의 내용을 가져오기
				GenericXmlApplicationContext context =  new GenericXmlApplicationContext ("classpath:applicationContext.xml");	
				){
			//bean 태그 객체 가져오기
			Player player = context.getBean("player", Player.class);
			System.out.println(player);
			
			Player player1 = context.getBean("player1", Player.class);
			System.out.println(player1);
			
			
			Player player2 = context.getBean("player2", Player.class);
			System.out.println(player2);
			
			
		}catch(Exception e) {
			System.out.println("예외:"+ e.getMessage());
			e.printStackTrace();
		}

	}

}
