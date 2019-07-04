package kr.co.item.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.item.domain.Item;

@Repository
public class ItemDao {
   @Autowired
   private SqlSession sqlSession;
   
   //전체 데이터를 가져오는 메소드
   public List<Item> allItem(){
	   return sqlSession.selectList("item.allitem");
   }
   
   //itemid를 가지고 하나의 데이터만 찾아오는 메소드
   public Item getItem(int itemid) {
	   return sqlSession.selectOne("item.getitem", itemid);
   }
   
}
