package good.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import good.domain.Good;

@Repository
public interface GoodMapper {

    //goods 테이블의 전체 데이터 가져오기	
	 @Select("select * from goods")
	public List<Good> allGood();
	 
	 //goods 테이블에서 code(pribary key)를 가지고 데이터 기져오기
	 @Select("select * from goods where code =#{code}")
	 public Good codeSearch(int code);
	 
	 //goods 테이블에 데이터를 삽입하는 메소드
	 @Insert("insert into goods(code, name, manufacture, price) "
			 + "values(#{code}, #{name}, #{manufacture}, #{price})")
	 public int insertGood(Good good);
	 
	 //goods 테이블의 데이터를 수정하는 메소드
	 @Update("update goods "
			  + "set name =#{name}, manufacture =#{manufacture}, price=#{price} "
			 + "where code =#{code}")
	 public int updateGood(Good good);
	 
	 //goods 테이블의 데이터를 삭제하는 메소드
	 @Delete("delete from goods where code = #{code}")
	 public int deleteGood(int code);
}
