package mybatis.domain;

import lombok.Data;

@Data
public class Singer {
	//데이터베이스 테이블의 컬럼이름과 일치하는지 확인
     private int num;
     private String name;
     private String majorsong;

}
