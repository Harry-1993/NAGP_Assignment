package com.harsimran.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class UserLoginTest extends SpringBootTestApplication {

	@Autowired
	private WebApplicationContext web;

	private MockMvc mock;

	@org.junit.Before
	public void setup() {
		mock = MockMvcBuilders.webAppContextSetup(web).build();

	}

	@Test
	public void testLogin() throws Exception {
		mock.perform(get("/login")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.username").value("harsimran"))
				.andExpect(jsonPath("$.password").value("asdf1234"));
	}

}
