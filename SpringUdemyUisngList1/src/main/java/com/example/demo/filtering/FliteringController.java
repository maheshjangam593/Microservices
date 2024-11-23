package com.example.demo.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FliteringController {

	@GetMapping("/filter")	
	public MappingJacksonValue filterBy()
	{
		Filter bean=new Filter("value1","valu2","value3");
		
		 
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("f2","f3");
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeFilter",filter);
		
		MappingJacksonValue mapping= new MappingJacksonValue(bean);
		mapping.setFilters(filters);
		return mapping;
	}
	
}
