package com.ionep.egis.current.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class CityCommandTest {
	
	@Test
	public void constructorCity() throws Exception {
		CityCommand cityCommand = new CityCommand("BALTIMORE_MD");
		assertNotNull(cityCommand);
		assertEquals("BALTIMORE_MD", cityCommand.getCity());
	}

	@Test
	public void constructorCityCommand() throws Exception {
		CityCommand cityCommand = new CityCommand("BALTIMORE_MD", "SUSPEND");
		assertNotNull(cityCommand);
		assertEquals("BALTIMORE_MD", cityCommand.getCity());
		assertEquals("SUSPEND", cityCommand.getCommand());
	}

}
