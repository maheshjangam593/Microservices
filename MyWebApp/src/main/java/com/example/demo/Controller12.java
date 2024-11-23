package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//@RestController

@Controller
public class Controller12 {
	//@Autowired
//	@Value("${custom.port}")
//	private String Port;
//	@RequestMapping("/Controller")
	@RequestMapping("/home")
	public ModelAndView home(@RequestParam("name") String myName) {
//public String home(HttpServletRequest req,HttpServletResponse res) {
//		//System.out.println("port nbr is  " + Port);
//		HttpSession session=req.getSession();
//		String name=req.getParameter("name");
//		System.out.println("hi "+ name);
//		session.setAttribute("name", name);
//		
//		System.out.println("Chill");
		ModelAndView mv=new ModelAndView();
		mv.addObject("name",myName);
		mv.setViewName("home");
		return mv;
		
	}
}
