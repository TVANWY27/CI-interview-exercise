package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	public String getInfo() {
		return "test";

		// parametre en entrée qui donne un resultat
		//
	}
}
