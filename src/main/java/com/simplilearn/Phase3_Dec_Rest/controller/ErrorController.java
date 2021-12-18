package com.simplilearn.Phase3_Dec_Rest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {
	
	
	@GetMapping("/calculate")
	//@RequestMapping(value="/calculate", method= "GET")
	public Integer calculate() {
		int a = 6;
		int b = 0;
		int result = 0;
		result = a / b;
		return result;
	}

}
