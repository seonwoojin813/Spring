package kr.co.pk.interceptor;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

//AOP에 사용할 클래스 
//인스턴스를 자동으로 생성하기위한 어노테이션
@Component
public class LoggingAdvice {
	//AOP로 동작할 메소드 : 리턴타입이 Object이어야하고
	//매개변수가 ProceedingJoinPoint여야 합니다.
	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
		//오늘 날짜를 문자열 만들기
		//sql에 데이트
		Date today = new Date(System.currentTimeMillis());
		String filename = today.toString();
		//동일한 이름의 파일이 있으면 추가하고 그렇지 않으면 생성하기
		String filepath = 
				"/Users/a503_08/Downloads/" + 
				filename + ".log";
		FileOutputStream fos=
				new FileOutputStream(filepath, true);
		PrintWriter pw = new PrintWriter(fos);
		//파일에 기록
		//util의 데이
		pw.println(new java.util.Date(
				System.currentTimeMillis()));
		pw.flush();
		fos.close();
		pw.close();
		
				
		//현재 시간 구하기
		long start = System.currentTimeMillis();
		//원본 메소드 호출
	   Object obj = joinPoint.proceed();
		long end = System.currentTimeMillis();
		
		//작업에 걸린 시간 출력
		System.out.println("걸린시간:" + (end-start));
	   
		return obj;
	}
}