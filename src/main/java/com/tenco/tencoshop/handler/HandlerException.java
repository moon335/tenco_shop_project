package com.tenco.tencoshop.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tenco.tencoshop.handler.exception.LoginException;

@RestControllerAdvice
public class HandlerException {

//   @ExceptionHandler(LoginException.class)
//   public String basicException(LoginException e) {
//      StringBuffer sb = new StringBuffer();
//      sb.append("<script>");
//      sb.append("alert('" + e.getMessage() + "');");
//      sb.append("location.href='/user/sign-in';");
//      sb.append("</script>");
//      return sb.toString();
//   }

//   //사용자 로그인 안했을 때
	@ExceptionHandler(LoginException.class)
	public String unAuthorizedException(LoginException e) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("alert('" + e.getMessage() + "');");
		sb.append("location.href='/user/sign-in';");
		sb.append("</script>");

		return sb.toString();
	}

}
