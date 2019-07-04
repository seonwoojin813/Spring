package hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hibernate.domain.Sample;

@Repository
public class SampleDAO {
@Autowired
private SessionFactory sessionFactory;

@Transactional
public void upsert(Sample sample) {
	Session session = sessionFactory.getCurrentSession();
	//없는 id이면 삽입 있는 id이면 수정
	session.saveOrUpdate(sample);
}
@Transactional
public Sample get(int num) {
	Session session = sessionFactory.getCurrentSession();
	//없는 id이면 삽입 있는 id이면 수정
	return session.get(Sample.class, num);
}	
}
