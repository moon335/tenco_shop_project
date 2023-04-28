package com.tenco.tencoshop.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tenco.tencoshop.handler.exception.CustomRestfullException;

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
	
}
