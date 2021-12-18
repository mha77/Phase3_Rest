package com.simplilearn.Phase3_Dec_Rest.config;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Component
public class GlobalExceptoinHandler {
	
	
	@ExceptionHandler(value= ArithmeticException.class)
	@ResponseBody
	public String arithmatcExceptionHandler(ArithmeticException e) {
		return "Internal error occurred from Global Handler"+e.getMessage();
	}
	

}
