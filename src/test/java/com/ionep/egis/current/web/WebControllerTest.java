package com.ionep.egis.current.web;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class WebControllerTest {
	
	@Test
	public void constructor() throws Exception {
		WebController webController = new WebController();
		assertNotNull(webController);
	}

}
