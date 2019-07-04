package good.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//접근자 메소드, toString, hashCode, equals 메소드가 생성
@Data
//매개변수가 없는 생성자가 생성자
@NoArgsConstructor
//인스턴스 변수가 전부 매개변수가 되는 생성자
@AllArgsConstructor		
public class Good {
       private int code;
       private String name;
       private String manufacture;
       private int price;
}
