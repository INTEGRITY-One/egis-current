package com.ionep.egis.current.web;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

public class WebControllerTest {
	
	private WebControllerConfig config = new WebControllerConfig();
	
	@Test
	public void constructor() throws Exception {
		WebController webController = new WebController();
		assertNotNull(webController);
		assertNotNull(ReflectionTestUtils.getField(webController, "futures"));
		ReflectionTestUtils.setField(webController, "scheduler", this.config.scheduler());
		assertNotNull(ReflectionTestUtils.getField(webController, "scheduler"));
		ReflectionTestUtils.setField(webController, "kafkaTemplate", this.config.kafkaTemplate());
		assertNotNull(ReflectionTestUtils.getField(webController, "kafkaTemplate"));
	}

	@Test
	public void create() throws Exception {
		WebController webController = new WebController();
		ReflectionTestUtils.setField(webController, "scheduler", this.config.scheduler());
		ReflectionTestUtils.setField(webController, "kafkaTemplate", this.config.kafkaTemplate());
		webController.create("BALTIMORE_MD");
	}

	@Test
	public void delete() throws Exception {
		WebController webController = new WebController();
		ReflectionTestUtils.setField(webController, "scheduler", this.config.scheduler());
		ReflectionTestUtils.setField(webController, "kafkaTemplate", this.config.kafkaTemplate());
		webController.create("BALTIMORE_MD");
		webController.delete("BALTIMORE_MD");
	}

}
