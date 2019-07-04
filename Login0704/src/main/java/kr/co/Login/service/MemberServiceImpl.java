package kr.co.Login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.Login.dao.MemberDao;
import kr.co.Login.domain.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberDao;
	
	@Override
	public Member login(Member member) {
	   member.setId(member.getId().toUpperCase());
		//System.out.println("서비스:" + member);
		return memberDao.login(member);
	}

}
