package com.ionep.egis.current.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class CurrentConditionsTest {
	
	@Test
	public void constructor() throws Exception {
		CurrentConditions conditions = new CurrentConditions();
		assertNotNull(conditions);
	}
	
	@Test
	public void allFields() throws Exception {
		Temperature temperature = new Temperature();
		temperature.setTemp(72);
		Precipitation precipitation = new Precipitation();
		precipitation.setPrecip(2);
		Humidity humidity = new Humidity();
		humidity.setHumid(30);
		Cloudiness cloudiness = Cloudiness.CLEAR;
		Wind wind = new Wind();
		wind.setDirection(WindDirection.EAST);
		wind.setSpeed(5);
		Pressure pressure = new Pressure();
		pressure.setPress(30);
		CurrentConditions conditions = new CurrentConditions();
		conditions.setTemperature(temperature);
		conditions.setPrecipitation(precipitation);
		conditions.setHumidity(humidity);
		conditions.setCloudiness(cloudiness);
		conditions.setWind(wind);
		conditions.setPressure(pressure);
		assertEquals(temperature, conditions.getTemperature());
		assertEquals(precipitation, conditions.getPrecipitation());
		assertEquals(humidity, conditions.getHumidity());
		assertEquals(cloudiness, conditions.getCloudiness());
		assertEquals(wind, conditions.getWind());
		assertEquals(pressure, conditions.getPressure());
	}

}
