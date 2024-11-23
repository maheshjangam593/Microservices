package com.example.demo.HelloWorld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController	
public class HelloWorldController {

	@Autowired
	private MessageSource resource;

	@GetMapping("/Internalization")
	public String HelloWorldIntern(

			//@RequestHeader(name = "Accept-Language", required = false) Locale locale
			) {
		return resource.getMessage("good.morning.message", null, "defalut messge", //locale
				LocaleContextHolder.getLocale());
	}

}
