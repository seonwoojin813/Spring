package hibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hibernate.domain.TODO;

@Repository
public class TODODAO {
	//hibernate 연동 객체를 자동으로 주입
@Autowired
private SessionFactory sessionFactory;

//데이터를 삽입하는 메소드
@Transactional
public void insertTODO(TODO todo) {
	//Hibernate 작업을 위한 세션 가져오기
	Session session = sessionFactory.getCurrentSession();
	
	//데이터 삽입
	session.save(todo);
	
}

	//전체 데이터를 가져오는 메소드
	@Transactional
	public List<TODO> listTODO(){		
		/*
		List<TODO> list =(List<TODO>)
		sessionFactory.getCurrentSession()
		.createCriteria(TODO.class).list();
		*/
		
		//SQL을 이용한 방법
		List<TODO> list =(List<TODO>)
				sessionFactory.getCurrentSession().createSQLQuery("select * from TODO").addEntity(TODO.class).list();
		
		
		return list;
		
	}
	
	@Transactional
	public TODO get(int code){
		TODO todo = sessionFactory.getCurrentSession().get(TODO.class, code);
		return todo;
		
	}
	
}


