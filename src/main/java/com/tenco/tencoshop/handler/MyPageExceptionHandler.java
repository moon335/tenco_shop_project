package com.tenco.tencoshop.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class MyPageExceptionHandler {

	@ExceptionHandler(Exception.class)
	public void exception(Exception e) {
		System.out.println(e.getClass().getName());
		System.out.println(e.getMessage());
	}
}
