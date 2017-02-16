package com.bit2017.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// @RequestMapping 메서드 단독 매핑

@Controller
public class UserController {

	@ResponseBody
	@RequestMapping( value="/user/join", method=RequestMethod.POST )
	public String join() {
		return "join";
	}

	@ResponseBody
	@RequestMapping( "/user/loginform" )
	public String loginform() {
		return "loginform";
	}
	
	@ResponseBody
	@RequestMapping( "/user/login" )
	public String login( @RequestParam("id") String id ) {
		
		return "login:" + id;
	}
	
}
