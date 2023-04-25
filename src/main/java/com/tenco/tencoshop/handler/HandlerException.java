package com.tenco.tencoshop.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerException {

   @ExceptionHandler(LoginException.class)
   public String basicException(LoginException e) {
      StringBuffer sb = new StringBuffer();
      sb.append("<script>");
      sb.append("alert('" + e.getMessage() + "');");
      sb.append("history.back();");
      sb.append("</script>");

      return sb.toString();
   }

}