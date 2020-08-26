package com.cos.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//LoginされてないUserへのPath
//url "/" は index.jsp
//static以下の/js/**,/css/**,image/**

@Controller
public class UserController {


	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "user/joinForm";

	}
	
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "user/loginForm";
		
	}
	
	

}
