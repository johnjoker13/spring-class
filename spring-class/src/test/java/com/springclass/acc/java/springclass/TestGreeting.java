package com.springclass.acc.java.springclass;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestGreeting {

	@Test
	@DisplayName("Testing content getter")
	void testContentGetter() {
		Greeting greeting = new Greeting(1, "John");
		assertEquals("John", greeting.getContent());
	}
	
	@Test
	@DisplayName("Testing id getter")
	void testIdGetter() {
		Greeting greeting = new Greeting(1, "John");
		assertEquals(1, greeting.getId());
	}

}
