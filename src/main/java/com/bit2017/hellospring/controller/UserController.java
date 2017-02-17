package com.bit2017.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2017.hellospring.vo.UserVo;

// @RequestMapping 메서드 단독 매핑

@Controller
public class UserController {

	@ResponseBody
	@RequestMapping( value="/user/join2", method=RequestMethod.POST )
	public String join2(
		@RequestParam(
			value="name", 
			required=true, 
			defaultValue="" ) String name,
		@RequestParam( 
				value="email", 
				required=true, 
				defaultValue="" ) String email,
		@RequestParam( 
				value="password", 
				required=true, 
				defaultValue="" ) String password
		) {
		
		UserVo vo = new UserVo();
		vo.setName( name );
		vo.setEmail( email );
		vo.setPassword(password);
		
		System.out.println( vo );
		
		return "join" ;
	}


	@RequestMapping( value="/user/join", method=RequestMethod.POST )
	public String join( @ModelAttribute UserVo vo ) {
		// 기술침투
		// 대신 스프링에서 엔코딩 필터를 제공해 줌
		//request.setCharacterEncoding( "utf-8" );
		
		System.out.println( vo );
		
		return "redirect:/user/joinsuccess" ;
	}
	
	@ResponseBody
	@RequestMapping( "/user/joinsuccess" )
	public String joinSuccess() {
		return "joinSuccess";
	}
	
	@RequestMapping( "/user/joinform" )
	public String joinForm(){
		return "/WEB-INF/views/joinform.jsp";
	}
	
	@ResponseBody
	@RequestMapping( "/user/loginform" )
	public String loginform() {
		return "loginform";
	}
	
	@ResponseBody
	@RequestMapping( "/user/login" )
	public String login( 
		@RequestParam("id") String id,
		@RequestParam("pwd") String password ) {
		return "login:" + id + ":" + password;
	}

	@ResponseBody
	@RequestMapping( "/user/login2" )
	public String login2( 
		@RequestParam(value="id", required=true, defaultValue="" ) String id,
		@RequestParam(value="pwd", required=true, defaultValue="" ) String password,
		@RequestParam(value="no", required=true, defaultValue="-1") Long no) {
		return "login:" + id + ":" + password + ":" + no;
	}
	
	@ResponseBody
	@RequestMapping( "/user/login3" )
	public String login3( 
		@RequestParam String id, /* 파라미터 이름과 값을 저장할 변수 이름이 같으면 생략 가능 */
		@RequestParam("pwd") String password ) {
		return "login:" + id + ":" + password;
	}	
}
