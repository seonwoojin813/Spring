package ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//다른 클래스의 인스턴스를 대신 생성해주는 클래스
@Configuration  //Spring의 BeanFactory를 만드는 예약어
public class DAOFactory {
	@Bean //Spring의 Bean을 생성하는 메소드를 만드는 예약어
    public static PlayerDAO create() {
    	PlayerDAO dao = new PlayerDAO();
    	return dao;
    }
}
