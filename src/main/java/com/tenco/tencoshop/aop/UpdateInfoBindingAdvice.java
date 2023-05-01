package com.tenco.tencoshop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.tenco.tencoshop.handler.exception.CustomRestfullException;

@Aspect
@Component
public class UpdateInfoBindingAdvice {
	
	@Pointcut("execution(* com.tenco.tencoshop.controller..*.myInfoUp*(*,*))")
	public void cut() {
		
	}
	
	@Before("cut()")
	public void before(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		for (Object arg : args) {
			if(arg instanceof BindingResult) {
				BindingResult bindingResult = (BindingResult)arg;
				if(bindingResult.hasErrors()) {
					StringBuilder sb = new StringBuilder();
					
					bindingResult.getAllErrors().forEach(error -> {
						String errMsg = error.getDefaultMessage();
						sb.append(errMsg).append("\\n");
					});
					throw new CustomRestfullException(sb.toString(), HttpStatus.BAD_REQUEST);
				}
			}
		}
	}
	
} // end of class
