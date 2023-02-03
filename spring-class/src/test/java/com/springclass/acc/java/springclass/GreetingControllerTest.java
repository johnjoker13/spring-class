package com.springclass.acc.java.springclass;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class GreetingControllerTest {
	
	@Autowired
	private GreetingController _greetingController;
	
	@Test
	void contextLoads() throws Exception {
		assertThat(_greetingController).isNotNull();
	}
	
	@Value(value = "${local.server.port}")
	private int _port;
	
	@Autowired
	private  TestRestTemplate _restTemplate;
	
	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		assertThat(this._restTemplate.getForObject("http://localhost:" + _port + "/greeting", String.class)).contains("Hello, World");
	}
	
	@Test
	public void greetingShouldReturnCustomMessage() throws Exception {
		assertThat(this._restTemplate.getForObject("http://localhost:" + _port + "/greeting?name=John", String.class)).contains("Hello, John");
	}
	
}
