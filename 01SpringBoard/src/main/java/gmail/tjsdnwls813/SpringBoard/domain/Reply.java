package gmail.tjsdnwls813.SpringBoard.domain;

import lombok.Data;

//MyBatis에서 DTO 클래스를 만들 때는 이름에 주의
//매핑 구문을 별도로 작성하지 않으면 컬럼이름이 프로터피와 같아야합니다.
//이름을 틀렸을 떄 발생하는 예외가 프로퍼티가 없다는 예외입니다.
@Data
public class Reply {

	 private int rno;
	 private String replytext;
	 //Date 타입은 연산을 할 때는 편리하지만 출력을 할 때는 불편해서 String으로
	 private String  regdate;
	 //출력할 날짜 포맷을 저장할 프로퍼티
	 private String  datedisp;
	 private String  email;
	 private String  nickname;
	 private int bno;
}
