package com.example.demo;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/get")
						.filters(f -> f.addRequestHeader("MyHeader", "MyUri").addRequestParameter("MyParams", "PAmam1"))
						.uri("http://httpbin.org:80"))
				.route(p -> p.path("/currency-exchange/**").uri("lb://currency-exchange-servicev2"))
				.route(p -> p.path("/currency-conversion2/**")
						.filters(f -> f.rewritePath("/currency-conversion2/(?<segment>.*)",
								"/currency-conversion/${segment}"))
						.uri("lb://currency-conversion-servicev2"))
				.route(p -> p.path("/currency-conversion/**").uri("lb://currency-conversion-servicev2")).build();

	}
}
