package gmail.tjsdnwls813.SpringBoard.domain;

import lombok.Data;

@Data
public class User {
      private String email;
      private String pw;
      private String nickname;
      private String image;
      
      //@Data 말고 getters and setters로 하고 toSting으로 해줘도됨
      
}
