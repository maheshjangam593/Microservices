package com.example.Zcontollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Alien;

@Controller
public class AlienController {
	@Autowired
	@RequestMapping("/home")
	public String home()
	{
		System.out.println("hello");
		return "home.jsp";
	}
	public String addAlien(Alien alien)
	{
		return "home.jsp";
	}

}
