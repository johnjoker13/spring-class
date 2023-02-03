package com.springclass.acc.java.springclass;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class GreetingController {
	private static final String template = "Hello, %s";
	private final AtomicLong counter = new AtomicLong();
	
	@ApiOperation(value = "Returns a greeting")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Returns a greeting"),
			@ApiResponse(code = 403, message = "Forbidden"),
		    @ApiResponse(code = 500, message = "Internal Error"),
	})
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
