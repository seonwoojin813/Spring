import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Date;
import java.util.GregorianCalendar;

import org.springframework.context.support.GenericXmlApplicationContext;

import hibernate.dao.SampleDAO;
import hibernate.domain.Sample;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		
	SampleDAO dao = context.getBean(SampleDAO.class);	
		
	/*
	Sample sample = new Sample();
	sample.setNum(2);
	sample.setName("정유미");
	
	//Date 객체를 만들어서 대입
	GregorianCalendar cal = new GregorianCalendar(
			1982, 12, 8 );
	Date regdate = new Date(cal.getTimeInMillis());
	sample.setRegdate(regdate);
	
	
	//이미지 파일을 가지고 바이트 배열 만들기
	String imageFile = "/Users/a503_08/Downloads/image/spaa.jpg";
	File f =  new File(imageFile);
	try {
		byte [] b = new byte[(int)f.length()];
		FileInputStream fis = new FileInputStream(f);
		fis.read(b);
		sample.setImage(b);
		fis.close();
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	    //System.out.println("log:" + sample);
	   
	   dao.upsert(sample);
	   
	   
		context.close();
	*/
	

	Sample sample = dao.get(1);
	System.out.println(sample);
	try {
		FileOutputStream fos= new FileOutputStream("./spaa.jpg");
		fos.write(sample.getImage());
		fos.flush();
		fos.close();
	}catch(Exception e) {}
	

		context.close();
	}

}
