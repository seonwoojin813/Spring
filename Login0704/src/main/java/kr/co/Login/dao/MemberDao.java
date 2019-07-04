package kr.co.Login.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.Login.domain.Member;

@Repository
public class MemberDao {
	@Autowired
	SqlSession sqlSession;
	
	//로그인 처리 메소드
	public Member login(Member member) {
		//System.out.println("dao:" + member);
		return sqlSession.selectOne("member.login", member);
		
	}
	
}
