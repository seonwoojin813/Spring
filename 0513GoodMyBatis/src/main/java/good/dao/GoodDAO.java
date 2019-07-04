package good.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;


import good.domain.Good;


//Repository 클래스의 인스턴스를 자동으로 생성하기 위한 어노테이션
//@Repository
public class GoodDAO {
	//동일한 자료형의 인스턴스를 자동으로 주입하기 위한 어노테이션
	@Autowired
private SqlSession sqlSession;
	
	//Goods 테이블의 데이터 전체를 읽어오는 메소드
	public List<Good> allGood(){
		//good.allgood이라는 sql을 실행해서 결과를 List로 변환
		return sqlSession.selectList("good.allgood");
	}
	
	//Goods 테이블에서 code를 가지고 데이터를 읽어오는 메소드
	//1개의 행을 리턴하는 메소드는 검색된 데이터가 없으면 null을 리턴
	public Good codeSearch (int code) {
		return sqlSession.selectOne("good.codesearch", code);
	}
	
	//Goods 테이블에 데이터를 삽입하는 메소드
	public int insertGood(Good good) {
		return sqlSession.insert("good.insertgood", good);
	}
	
	//Goods 테이블의 데이터를 수정하는 메소드
	public int updateGood(Good good) {
		return sqlSession.update("good.updategood", good);
	}
	
	//Goods 테이블의 데이터를 삭제하는 메소드
	public int deleteGood(int code) {
		return sqlSession.delete("good.deletegood", code);
	}
	
	
}
