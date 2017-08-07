package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController 以json格式输出
 * @author zhaoyue
 *
 */
@RestController
public class HelloWorldController {
	
	@RequestMapping("/hello")
	public String index() {
		return "Hello World";
	}
	
}
