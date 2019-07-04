package good.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//import good.dao.GoodDAO;
import good.dao.GoodMapper;
import good.domain.Good;

//Service 클래스의 인스턴스를 자동으로 생성해주는 어노테이션
@Service
public class GoodService {
@Autowired
//private GoodDAO goodDao;
private GoodMapper goodDao;

//전체보기를 수행할 메소드
public void allGood() {
	List<Good> list = goodDao.allGood();
	
	//데이터 출력
	for(Good good : list) {
		System.out.println(good);
	}
}

//코드를 입력받아서 데이터를 조회한 후 출력해주는 메소드
public void codeSearch(Scanner sc) {
	while(true) {
   System.out.print("조회할 코드를 입력:");
   String input = sc.nextLine();
   int code = -1;
   try {
	   code = Integer.parseInt(input);
   }catch(Exception e) {
	   System.out.println("코드는 정수로 입력하세요");
	   continue;
    }
       //DAO의 메소드 호출
        Good good = goodDao.codeSearch(code);
        //데이터가 없는 경우
        if(good == null) {
        	System.out.println("코드에 해당하는 데이터가 없습니다.");
        }
        //데이터가 없는 경우
        else {
        	System.out.println(good);
        }

      break;
    } 
   }

//데이터를 삽입하는 메소드
public void insertGood(Scanner sc) {
	while(true) {
		System.out.println("삽입할 코드입력:");
		String input = sc.nextLine();
		int code= -1;
		try {
			 code = Integer.parseInt(input);
		}catch(Exception e) {
			   System.out.println("코드는 정수로 입력하세요");
			   continue;
	}
		
		
		//중복검사
		Good good  = goodDao.codeSearch(code);
		//중복된 code이면 코드를 다시 입력하도록 설정
		if(good != null) {
			System.out.println("이미 존재하는 code입니다.");
			continue;
		}
		
		//나머지 입력받기
		System.out.println("이름 입력:");
		String name = sc.nextLine();
		System.out.println("원산지 입력:");
		String manufacture = sc.nextLine();
		int price = -1;
		while (true) {
			System.out.println("가격입력:");
			input = sc.nextLine();
			try {
				price = Integer.parseInt(input);
			} catch (Exception e) {
				System.out.println("가격은 정수로 입력하세요");

             continue;
			}
		break;
		
            }
		
		
		good = new Good();
		good.setCode(code);
		good.setName(name);
		good.setManufacture(manufacture);
		good.setPrice(price);
		
		//DAO의 메소드 호출
		int r = goodDao.insertGood(good);
		
		//결과를 확인
		if(r >= 1) {
			System.out.println("데이터 삽입 성공");
		}else {
			System.out.println("데이터 삽입 실패");
		}

		break;

         }
}
	
	
	//데이터를 수정하는 메소드
	public void updateGood(Scanner sc) {
		while(true) {
			System.out.print("코드입력");
			String input = sc.nextLine();
			int code = -1;
			try {
				code = Integer.parseInt(input);
				
			}catch(Exception e) {
				System.out.println("코드는 정수로 입력하세요");

	             continue;
			}
			
		//데이터 존재여부 확인
			Good good = goodDao.codeSearch(code);
			if(good == null) {
				System.out.println("존재하지 않는 코드입니다.");
			      continue;
			}
			
			System.out.print("이름 입력(기존 이름" +  good.getName() + ")");
			String name = sc.nextLine();
			System.out.print("이름 입력(기존 원산지" +  good.getManufacture()+ ")");
			String manufacture = sc.nextLine();
			
			int price = -1;
			while(true) {
				System.out.print("가격입력(기존 가격" + good.getPrice() + "):");
				input = sc.nextLine();
			try {
				price = Integer.parseInt(input);
			}catch(Exception e) {
				System.out.println("가격은 정수로 입력하세요");
				continue;

			}
			break;
			}
			
			//DAO가 사용할 매개변수를 생성
			good = new Good(code, name, manufacture, price);
			
			int r = goodDao.updateGood(good);
			
			//수정을 할 때는 0이면 where 절에 맞는 데이터가 없음
			//1이상이면 수정한 데이터가 존재
			if(r >= 1) {
				System.out.println("수정 성공");
				
			}else {
				System.out.println("수정 실패");
			}
			break;
		}
      }
	
 //데이터를 삭제하는 메소드
	public void deleteGood(Scanner sc) {
		while(true) {
			//삭제할 코드 입력
			System.out.print("삭제할 코드 입력:");
			String input = sc.nextLine();
			int code = -1;
			try {
				code = Integer.parseInt(input);
			}catch(Exception e) {
				System.out.println(	"코드는 정수로 입력하세요");
				continue;
			
			}
			//데이터의 존재 여부 확인
			Good good = goodDao.codeSearch(code);
			if(good == null) {
			  System.out.println("존재하지 않는 코드입니다.");
			  //메인화면으로 이동
			  return;
			}

			System.out.print("정말로 삭제(1:삭제 2:취소)");
			input = sc.nextLine();
			if(input.equals("1")) {
				int r = goodDao.deleteGood(code);
				System.out.println("Delete  구문");
				if(r >= 1) {
					System.out.println("1");
					System.out.println("데이터 삭제 성공");
				}else {
					
					System.out.println("데이터 삭제 실패");
				}
			}
			
			
			break;
		}
	}
	
}