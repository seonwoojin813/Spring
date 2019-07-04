package kr.co.pk;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.pk.domain.Boxer;

@Repository
public class BoxerDAO {
@Autowired
private SqlSession sqlSession;

//로그인 처리 메소드
public Boxer login(Boxer boxer) {
	System.out.println("dao:" + boxer);
	Boxer result = sqlSession.selectOne("boxer.login", boxer);
	return result;
}
}
