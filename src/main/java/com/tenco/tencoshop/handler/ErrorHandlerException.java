package com.tenco.tencoshop.handler;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

@ControllerAdvice
@Controller
public class ErrorHandlerException implements ErrorController {

	private static final String ERROR_PATH = "/error";

	@GetMapping(ERROR_PATH)
	public String handleError(HttpServletRequest request, Model model) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

		if (status != null && Integer.parseInt(status.toString()) == HttpStatus.NOT_FOUND.value()) {
			return "layout/errorPage";
		}

		return "layout/main";
	}

}
