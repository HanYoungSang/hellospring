package com.bit2017.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//@RequestMapping 타입(클래스) + 메서드 매핑

@Controller
@RequestMapping( "/guestbook" )
public class GuestbookController {

	@ResponseBody
	@RequestMapping( "/list" )
	public String list() {
		return "list";
	}

	@ResponseBody
	@RequestMapping( "/deleteform" )
	public String deleteform(
		@RequestParam(
			value="no", 
			required=true, 
			defaultValue="-1") Long no ){
		
		return "deleteform" + ":" + no;
	}
	
	@ResponseBody
	@RequestMapping( "/deleteform2/{no}" )
	public String deleteform2( @PathVariable("no") Long no ){
		return "deleteform" + ":" + no;
	}	
	
	@ResponseBody
	@RequestMapping( "/delete" )
	public String delete(){
		return "delete";
	}	
}
