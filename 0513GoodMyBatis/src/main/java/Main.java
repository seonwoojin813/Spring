import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import good.service.GoodService;

public class Main {

	public static void main(String[] args) {
		//입력을 받기 위한 인스턴스를 생성
		Scanner sc = new Scanner(System.in);
		
		//service 인스턴스 가져오기
		//스프링 설정 파일 실행
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		GoodService service = context.getBean("goodService", GoodService.class);
		
		//레이블을 붙인 반복문 - break나 continue 뒤에 레이블을 붙이면
		//레이블이 붙은 반복문을 종료
		logic: while(true) {
			System.out.println("=============================");
			System.out.println("1.전체보기 2.코드로 검색 3.데이터 삽입 4.데이터 수정 5.데이터 삭제 6.종료");
			System.out.printf("메뉴입력:");
			String input = sc.nextLine();
			
			int menu = -1;
			try {
				//입력받은 내용을 정수로 변환
				menu = Integer.parseInt(input);
				
			}catch(Exception e) {
				System.out.println("메뉴는 정수로 입력하세요!!!!");
				continue;			
				}
			//메뉴 범위를 넘어서면 다시 처음으로
			if(menu < 1 || menu > 6) {
				System.out.println("메뉴는 1-6 사이로 입력하세요!!!!");
				continue;		
			}
			
		  switch(menu){
			  case 1:
				  //System.out.println("전체보기를 선택");
				  service.allGood();
				  break;
			  case 2:
				  //System.out.println("코드검색을 선택");
				  service.codeSearch(sc);
				  break;
			  case 3:		  
				 // System.out.println("데이터 삽입 선택");
				 service.insertGood(sc);
				  break;
			  case 4:
				//System.out.println("데이터 수정 선택");
				  service.updateGood(sc);
				  break;
			  case 5:
				  //System.out.println("데이터 삭제 선택");
				  service.deleteGood(sc);
				  break;
			  case 6:
				  System.out.println("프로그램 종료!!!!");
				  //logic 이라는 레이블을 가진 반복문을 종료
				  break logic;
			
		  }
		}
		sc.close();
		context.close();
		//프로그램 정상 종료
		System.exit(0);
	}

}
