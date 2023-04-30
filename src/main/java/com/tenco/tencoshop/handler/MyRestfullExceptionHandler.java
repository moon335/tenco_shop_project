package com.tenco.tencoshop.handler;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tenco.tencoshop.handler.exception.CustomRestfullException;
import com.tenco.tencoshop.handler.exception.LoginException;

@RestControllerAdvice
public class MyRestfullExceptionHandler {

	@ExceptionHandler(Exception.class)
	public void exception(Exception e) {
		System.out.println(e.getClass().getName());
		System.out.println(e.getMessage());
	}
	
	@ExceptionHandler(CustomRestfullException.class)
	public String basicException(CustomRestfullException e) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("alert('"+e.getMessage()+"');");
		sb.append("history.back();");
		sb.append("</script>");
		
		return sb.toString();
	}
	
	@ExceptionHandler(LoginException.class)
	public String loginException(LoginException e) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("alert('"+e.getMessage()+"');");
		sb.append("location.href='/user/sign-in';");
		sb.append("</script>");
		
		return sb.toString();
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public String SQLUiqueException(CustomRestfullException e) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("alert('"+e.getMessage()+"');");
		sb.append("history.back();");
		sb.append("</script>");
		
		return sb.toString();
	}
	
}
