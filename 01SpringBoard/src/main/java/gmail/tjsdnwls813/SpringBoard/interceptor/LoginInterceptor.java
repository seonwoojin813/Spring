package gmail.tjsdnwls813.SpringBoard.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object handler)throws Exception{
		
	HttpSession session = request.getSession();	
	if(session.getAttribute("dest") == null ) {
		session.removeAttribute("loginmsg");
		
	}
	return true;
	}
}
