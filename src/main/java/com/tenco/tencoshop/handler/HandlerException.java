package com.tenco.tencoshop.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerException {

	@ExceptionHandler(LoginException.class)
	public String basicException(LoginException e) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		// 諛섎뱶�떆 留덉�留됱뿉 �꽭誘몄퐳濡좎쓣 遺숈뿬�꽌 �궗�슜�븯�옄
		sb.append("alert('" + e.getMessage() + "');");
		sb.append("history.back();");
		sb.append("</script>");

		return sb.toString();
	}

}
