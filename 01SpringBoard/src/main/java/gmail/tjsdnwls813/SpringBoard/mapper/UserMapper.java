package gmail.tjsdnwls813.SpringBoard.mapper;

import gmail.tjsdnwls813.SpringBoard.domain.User;

public interface UserMapper {
          public String emailcheck(String email);
          public String nicknamecheck(String nickname);
          public int register(User user);
          public User login(String email);
	   
}
