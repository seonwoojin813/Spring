

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import mybatis.dao.SingerDAO;



//스프링 설정 클래스로 만들기 위한 어노테이션
@Configuration
//인스턴스를 자동으로 생성할 클래스를 스캔할 패키지 설정
@ComponentScan(basePackages = "{mybatis.dao}")
public class RootConfig {

	   //DataSource 만들기
	 @Bean   
	public DataSource dataSource() {
		   DriverManagerDataSource dataSource = new DriverManagerDataSource();
		   
		   dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		   dataSource.setUrl("jdbc:log4jdbc:oracle:thin:@192.168.0.100:1521/XEPDB1");
		   dataSource.setUsername("user06");
		   dataSource.setPassword("user06");
		   
		   return dataSource;
	   }
		//SqlSessionFactoryBean 만들기 
		//applicaionContext.xml의 MyBatis 사용 객체 생성 부분 보고 적기
	//SqlSessionFactoryBean 만들기 
		//applicaionContext.xml의 MyBatis 사용 객체 생성 부분 보고 적기
		@Bean
		public SqlSessionFactory sqlSessionFactoryBean() throws Exception{
			SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
			sqlSessionFactoryBean.setDataSource(dataSource());
			//환경 설정 파일 경로 설정 
			sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
			//매퍼 파일 경로 설정
			Resource [] resources = new Resource[1];
			resources[0] = 
					new ClassPathResource("mappers/singer.xml");
			sqlSessionFactoryBean.setMapperLocations(resources);
			
			return sqlSessionFactoryBean.getObject();
		}
		
		@Bean
		public SqlSession sqlSession() throws Exception{
			SqlSession sqlSession = new SqlSessionTemplate(sqlSessionFactoryBean());
			return sqlSession;
		}
		
		//SingerDAO 인스턴스를 만들어주는 bean
		@Bean 
		public SingerDAO singerDAO() {
			SingerDAO singerDAO = new SingerDAO();
			return singerDAO;
		}
	 
}
