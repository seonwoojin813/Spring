package kr.co.pk.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//인스턴스를 만들기위한 어노테이션
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

	//Controller가 요청을 처리하기 전에 호출되는 메소드
	//이 메소드가 true를 리턴하면 Controller가 요청을 처리하러 이동하고
	//이 메소드가 false를 리턴하면 Controller로 요청을 처리하지 않는다
	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler) {
		//로그인 정보 확인 - 세션에 user 라는 이름의 객체가 있는지 확인 
		//user라는 이름은 직접 정하면 됩니다.
	   if(request.getSession().getAttribute("user") 
			      == null){
		   //로그인 되어 있지 않으면 login 페이지로 포워딩
		   try {
			   response.sendRedirect("login");
		   }catch(Exception e) {}
		   return false;
	   }
	   
		return true;
	
	}
	
	//Controller 처리 결과에 상관없이 호출되는 메소드
	@Override
	public void afterCompletion(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler,
			Exception ex) {
		//이전에 저장한 시간 가져오기
		//getAttribute는 object를 리턴하는데 object는 참조형으로만 형변환이 가능
		long start = (Long) request.getAttribute("start");
		System.out.println("Spend Time : " + (System.currentTimeMillis() - start));
		//호출한 메소드 확인
		//HandlerMethod method = (HandlerMethod)handler;
		//System.out.println("Called Method : " + method.getMethod());
	}
	//Controller가 정상적으로 요청을 처리한 후 호출되는 메소드
	//ModelAndView는 Controller가 처리한 결과
	@Override
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler,
			ModelAndView mav) {
		//어떤 뷰로 이동하여 출력하는지 출력
		//System.out.println("View Name : " + mav.getViewName());
	}
	
}
