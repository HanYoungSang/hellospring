package com.bit2017.hellospring.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping( "/hello" )
	public String hello(){
		return "/WEB-INF/views/hello.jsp";
	}
	
	// 비추천: POJO에 기술 침투는 바람직 하지 않다.
	@RequestMapping( "/hello2" )
	public void hello2(HttpServletRequest request, PrintWriter out) {
		String name = request.getParameter( "name" );
		out.println( "<h1>hello " + name + "</h1>" );
	}
	
}
