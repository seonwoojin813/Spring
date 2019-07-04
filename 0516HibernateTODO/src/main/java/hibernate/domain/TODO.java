package hibernate.domain;

 
import lombok.AllArgsConstructor; 
import lombok.Data; 
import lombok.NoArgsConstructor; 

@Data 

@NoArgsConstructor 

@AllArgsConstructor 
public class TODO {

	private int num; 
	private String title; 
	private String content; 
	private String rundate; 
}
