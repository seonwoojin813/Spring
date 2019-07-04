import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpSocketServer {

	public static void main(String[] args) {
		//서버소켓
		ServerSocket ss = null;
		//연결된 클라이언트 소켓
		Socket socket = null;		
		
		try {
			//서버소켓 생성
			ss = new ServerSocket(9999);
			while(true) {
				System.out.println("서버 대기 중");
				//접속대기
				socket = ss.accept();
				//접속자 정보 출력
				System.out.println("접속자:" + socket.toString());
				//클라이언트가 보낸 메시지 읽기
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String msg = br.readLine();
				System.out.println("전송된 메시지:" + msg);
				//클라이언트에게 메시지 보내기
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				pw.println("서버가 보내는 메시지");
				pw.flush();
				
			    br.close();
			    pw.close();
			    socket.close();
				
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				ss.close();
			}catch(Exception e) {}
		}

	}

}
