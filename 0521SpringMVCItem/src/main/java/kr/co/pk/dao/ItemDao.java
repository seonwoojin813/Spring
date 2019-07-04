package kr.co.pk.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.co.pk.domain.Item;

@Repository
public class ItemDao {
	//사용하는 데이터베이스 프레임워크 변수
  @Autowired
  private SqlSession sqlSession;
  @Autowired
  private SessionFactory sessionFactory;
  
  //Item 테이블의 모든 데이터를 가져오는 메소드
  @Transactional
  public List<Item> allItem(){
	  //return sqlSession.selectList("itemMapper.allItem");
	 Session session = sessionFactory.getCurrentSession();
	 return session.createCriteria(Item.class).list();
  }
  
  @Transactional
  //itemid를 이용해서 item 테이블에서 데이터를 가져오는 메소드
  public Item getItem(int itemid) {
	 //return sqlSession.selectOne("itemMapper.getItem", itemid);
	  Session session = sessionFactory.getCurrentSession();
	  return session.get(Item.class, itemid);
  }
  
}
