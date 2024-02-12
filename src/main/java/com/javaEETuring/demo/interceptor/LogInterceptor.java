package com.javaEETuring.demo.interceptor;

import java.util.Enumeration;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.javaEETuring.demo.service.AuthenticationException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		log.info("Basic Auth Interceptor");
		log.info("LogInterceptor :: Prehandle : " + request.getRequestURL());

		//String url = request.getRequestURL().toString();
		
		//Better way
		String url = request.getServletPath(); 
		log.info ("Servlet path :" + url);
		if(url.equals("/admin")) {
			
			log.info("Admin end point"); 
			//DO NOT USE GET METHOD IN REAL WORLD
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if("admin".equals(username) && "admin".equals(password)) {
				return true;
			}else {
				//return false;
				throw new AuthenticationException("Invalid user");
			}
		}else {
			Enumeration<String> headers =  request.getHeaderNames();
			while(headers.hasMoreElements()) {
				String name = headers.nextElement();
				String value = request.getHeader(name);
				log.info("Header " + name + " => " + value);
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		log.info("LogInterceptor :: Posthandle : " + request.getRequestURL());
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler,Exception ex) throws Exception {
		log.info("LogInterceptor :: AfterCompletion : " + request.getRequestURL());
		
	}
}
