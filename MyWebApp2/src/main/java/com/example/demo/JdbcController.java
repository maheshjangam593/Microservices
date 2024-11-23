package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;


@RestController
public class JdbcController {
	@Autowired
	private JdbcTemplate jdbc;
	@RequestMapping("/insert")
	public String insert()
	{
		jdbc.execute("insert into Office1(id,name1) values(1,'mahi')");
		return "data inserted successfulyy";
	}

}
