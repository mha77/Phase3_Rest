package com.simplilearn.Phase3_Dec_Rest;

import org.springframework.http.MediaType;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.Phase3_Dec_Rest.models.Greet;

@RestController
public class RestDemoController {

	@RequestMapping(value = "/greetMe", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
	public Greet greet() {
		Greet greet = new Greet();
		greet.setName("Dhruvik");
		greet.setMessage("Hello world!");
		return greet;
	}

}
