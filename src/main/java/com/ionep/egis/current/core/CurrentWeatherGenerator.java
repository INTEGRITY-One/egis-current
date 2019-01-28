package com.ionep.egis.current.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;

import com.ionep.egis.current.domain.Cloudiness;
import com.ionep.egis.current.domain.CurrentConditions;
import com.ionep.egis.current.domain.Humidity;
import com.ionep.egis.current.domain.Precipitation;
import com.ionep.egis.current.domain.Pressure;
import com.ionep.egis.current.domain.Temperature;
import com.ionep.egis.current.domain.Wind;
import com.ionep.egis.current.domain.WindDirection;

public class CurrentWeatherGenerator implements Runnable {

	private static Log log = LogFactory.getLog(CurrentWeatherGenerator.class);
	
	private String city;
	
	private KafkaTemplate<String, CurrentConditions> kafkaTemplate;
	
	private NewTopic topic;
	
	public CurrentWeatherGenerator(String city, KafkaTemplate<String, CurrentConditions> kafkaTemplate) {
		this.city = city;
		this.kafkaTemplate = kafkaTemplate;
		this.topic = new NewTopic(city, 1, (short)1);
	}
	
	public String getCity() {
		return this.city;
	}
	
	public NewTopic getTopic() {
		return this.topic;
	}
	
	@Override
	public void run() {
		generate();
	}
	
	protected void generate() {
		log.info("Conditions for city: " + getCity());
		log.info("-------------------- ");
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
		log.info("temperature  : " + conditions.getTemperature().getTemp());
		log.info("precipitation: " + conditions.getPrecipitation().getPrecip());
		log.info("humidity     : " + conditions.getHumidity().getHumid());
		log.info("cloudiness   : " + conditions.getCloudiness());
		log.info("wind         : " + conditions.getWind().getDirection() + " " + conditions.getWind().getSpeed());
		log.info("pressure     : " + conditions.getPressure().getPress());
		log.info("Sending to Kafka");
		this.kafkaTemplate.send(city, conditions);
		log.info("Sent to Kafka");
	}

}
