package gmail.tjsdnwls813.SpringBoard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gmail.tjsdnwls813.SpringBoard.domain.Reply;

@Repository
public class ReplyDao {
@Autowired
private SqlSession sqlSession;

//댓글 저장을 위한 메소드
//저장이면 리턴타입은 int  - 기억하기
public int register(Reply reply) {
	//System.out.println("DAO");
	
	//int result = sqlSession.insert("reply.register", reply);
	return sqlSession.insert("reply.register", reply);
	
	//System.out.println("DAO 결과:" + result);
	
	//return result;
}

//글번호에 해당하는 댓글 목록을 가져오는 메소드
public List<Reply> list(int bno){
	return sqlSession.selectList("reply.list", bno);
}

//댓글 번호에 해당하는 댓글을 삭제하는 메소드
public  int delete(int rno) {
	return sqlSession.delete("reply.delete", rno);
}

//댓글을 수정하는 메소드
public int update(Reply reply) {
	return sqlSession.update("reply.update", reply);
}

}
