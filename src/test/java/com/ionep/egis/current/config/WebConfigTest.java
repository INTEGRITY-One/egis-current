package com.ionep.egis.current.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class WebConfigTest {
	
	private WebConfig webConfig;
	
	@Test
	public void constructor() throws Exception {
		this.webConfig = new WebConfig();
		assertNotNull(this.webConfig);
	}

}
