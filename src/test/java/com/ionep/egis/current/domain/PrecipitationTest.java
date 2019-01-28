package com.ionep.egis.current.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class PrecipitationTest {

	@Test
	public void constructor() throws Exception {
		Precipitation precipitation = new Precipitation();
		assertNotNull(precipitation);
	}

	@Test
	public void precip() throws Exception {
		Precipitation precipitation = new Precipitation();
		precipitation.setPrecip(2);
		assertEquals(2, precipitation.getPrecip());
	}

}
