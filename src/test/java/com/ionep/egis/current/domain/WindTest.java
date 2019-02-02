package com.ionep.egis.current.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class WindTest {
	
	@Test
	public void constructor() throws Exception {
		Wind wind = new Wind();
		assertNotNull(wind);
	}
	
	@Test
	public void speedAndDirection() throws Exception {
		Wind wind = new Wind();
		wind.setDir(WindDirection.EAST.ordinal());
		wind.setSpeed(5);
		assertEquals(WindDirection.EAST.ordinal(), wind.getDir());
		assertEquals(5, wind.getSpeed());
	}

}
