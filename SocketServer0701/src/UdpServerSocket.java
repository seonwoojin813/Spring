import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServerSocket {

	public static void main(String[] args) {
		try (DatagramSocket ds = new DatagramSocket(8888)){
			System.out.println("서버 대기중");
		while(true) {
			byte [] data = new byte[65536];
			DatagramPacket dp = new DatagramPacket(data, 65536);
			ds.receive(dp);
			//보낸 곳의 주소 확인
			System.out.print("보낸 곳:"  +
					 dp.getAddress().toString());
			//보낸 메시지 확인
			String msg = new String(dp.getData());
					System.out.println("보낸메시지:" +  msg.trim());
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
