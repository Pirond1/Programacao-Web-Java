package com.pirondi.Aula5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
	
	@GetMapping("/hello")
	public String ola() {
		return "Hello World";
	}
	
	@GetMapping("/no")
	public String no() {
		return "Não";
	}
}
