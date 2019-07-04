package hibernate.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class Sample {
     private int num;
     private String name;
     private Date regdate;
     private byte[] image;
}
