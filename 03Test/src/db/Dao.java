package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
   //여기 임포트 다 java,sql
	//staic 변수는 인스턴스 변수를 쓸 수 없지만 일반 변수는 인스턴스 변수를 쓸 수 있음
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@192.168.0.100:1521/xe", "user06", "user06");
		return con;
	}
	
	//시퀀스 값을 가져오는 메소드(SELECT memberseq.nextval FROM dual;)
	public int getSequence() {
		int result = -1;
		try {
			//Connection 만들기
			Connection con = getConnection();
			//PreparedStatement 만들기
			//시퀀스 만들 때 ;주의
			PreparedStatement pstmt = con.prepareStatement("SELECT memberseq.nextval FROM dual");
			//SQL 실행  select | selsect ㅣ이외의 것인지 구분
			ResultSet rs = pstmt.executeQuery();
			//ResultSet은 1개인지 여러 개 인지 구분
            if(rs.next()) {
            	result = rs.getInt(1);
            	//쓸거 없으면 숫자 1적어
            }
            rs.close();
            pstmt.close();
            con.close();
            
		}catch(Exception e) {
			System.out.println("시퀀스 가져오기 에러:" + e.getMessage());
			
		}
		return result;
	}
	
	//데이터를 삽입하는 메소드
	public void insert(Member member) {
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into member_tbl_02("
					+ "custno, custname, phone, address, joindate, grade, city)"
					+ " values(?,?,?,?,?,?,?)");
			//values 앞에 한칸 띄어야해
			
			pstmt.setInt(1,  member.getCustno());
			pstmt.setString(2, member.getCustname());
			pstmt.setString(3, member.getPhone());
		    pstmt.setString(4, member.getAddress());
		    pstmt.setDate(5, member.getJoindate());
		    pstmt.setString(6, member.getGrade());
		    pstmt.setString(7, member.getCity());
		    								
			//실행
		    pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("시퀀스 가져오기 에러:" + e.getMessage());
			
		}
	}
	
}
