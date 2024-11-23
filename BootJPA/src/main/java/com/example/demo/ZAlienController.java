package com.example.demo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ZAlienController {
	@Autowired
	SqlDao sql;
	
	@Value("${spring.property.value}")
	private String value;
	
	@Scheduled(cron= "*/5 * * * * *")
	public void displayTime()
	{
		LocalDate d=LocalDate.now();
		System.out.println("for every 5 sec "+ d.now());
	}

	@GetMapping("/value")
	@ResponseBody()
	public String value() {
		System.out.println(value);
		return value;

	}
	@RequestMapping("/home")
	public String home() {
		System.out.println("hello");
		return "home.jsp";

	}
	/*
	 * @RequestMapping("/addAlien") public String addAlien(ZAlien1 alien) {
	 * sql.save(alien); return "home.jsp"; }
	 */

	@PostMapping("/addAlien")
	public ZAlien1 addAlien(@RequestBody ZAlien1 alien) {
		sql.save(alien);
		return alien;
	}

	@PutMapping("/addAlien")
	@ResponseBody
	public ZAlien1 updateAlien(@RequestBody ZAlien1 alien) {
		sql.save(alien);
		return alien;
	}
	// With out Rest Api using Model and view
	/*
	 * @RequestMapping("/getAlien") public ModelAndView getAlien(@RequestParam int
	 * aId) {
	 * 
	 * ModelAndView mv=new ModelAndView("ShowAlien.jsp"); ZAlien1
	 * alien=sql.findById(aId).orElse(new ZAlien1()); mv.addObject(alien);
	 * System.out.println(sql.findByName("mahi"));
	 * System.out.println(sql.findByaIdGreaterThan(aId));
	 * System.out.println(sql.findByNameSorted("mahi"));
	 * 
	 * return mv; }
	 */
//	@RequestMapping("/Aliens")
//	@ResponseBody()
//	public String getAlien() {
//
//		return sql.findAll().toString();
//	}
//
//	@RequestMapping("/Aliens/{aId}")
//	@ResponseBody()
//	public String getAlien(@PathVariable("aId") int aId) {
//
//		return sql.findById(aId).toString();
//	}

	// @RequestMapping(path = "/Aliens", produces = { "application/xml" })
	@RequestMapping(path = "/Aliens")
	@ResponseBody()
	public List<ZAlien1> getAlien() {

		return sql.findAll();
	}

	@RequestMapping("/Aliens/{aId}")
	@ResponseBody()
	public Optional<ZAlien1> getAlien(@PathVariable("aId") int aId) {

		return sql.findById(aId);
	}

	@DeleteMapping("/Aliens/{aId}")
	@ResponseBody()
	public String deleteAlien(@PathVariable("aId") int aId) {

		ZAlien1 a = sql.getById(aId);
		sql.delete(a);

		return "delted";
	}

}
