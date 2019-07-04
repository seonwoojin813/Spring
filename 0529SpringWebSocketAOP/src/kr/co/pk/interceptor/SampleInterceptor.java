package kr.co.pk.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//public class SampleInterceptor implements HandlerInterceptor {
//인스턴스를 자동으로 생성해주는 어노테이션
@Component
public class SampleInterceptor extends HandlerInterceptorAdapter {
	//Controller가 요청을 처리하기 전에 호출되는 메소드
	//이 메소드가 true를 리턴하면 Controller가 요청을 처리하러 이동하고
	//이 메소드가 false를 리턴하면 Controller로 요청을 처리하지 않는다
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler) {
		//현재 시간을 request에 저장
		request.setAttribute("start", System.currentTimeMillis());
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