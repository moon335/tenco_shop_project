package com.tenco.tencoshop.handler;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class LoginException extends RuntimeException {

	private HttpStatus status;

	public LoginException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}

}
