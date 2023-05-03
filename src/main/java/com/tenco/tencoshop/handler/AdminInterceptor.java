package com.tenco.tencoshop.handler;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.tenco.tencoshop.dto.LoginResponseDto;
import com.tenco.tencoshop.handler.exception.CustomRestfullException;
import com.tenco.tencoshop.handler.exception.LoginException;
import com.tenco.tencoshop.util.Define;

@Component
public class AdminInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		LoginResponseDto principal = (LoginResponseDto)session.getAttribute(Define.PRINCIPAL);
		if(principal == null) {
			throw new LoginException("관리자 로그인 후 이용 가능한 서비스 입니다.", HttpStatus.UNAUTHORIZED);
		}
		
		if(principal.getRole().equals("admin") == false) {
			throw new CustomRestfullException("해당 페이지에 접근 권한이 없습니다.", HttpStatus.FORBIDDEN);
		}
		
		return true;
	}
	
}
