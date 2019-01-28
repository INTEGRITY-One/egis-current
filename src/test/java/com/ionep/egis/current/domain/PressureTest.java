package com.ionep.egis.current.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class PressureTest {

	@Test
	public void constructor() throws Exception {
		Pressure pressure = new Pressure();
		assertNotNull(pressure);
	}

	@Test
	public void temp() throws Exception {
		Pressure pressure = new Pressure();
		pressure.setPress(30);
		assertEquals(30, pressure.getPress());
	}

}
