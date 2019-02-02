package com.ionep.egis.current.web;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ionep.egis.current.core.CurrentWeatherGenerator;
import com.ionep.egis.current.domain.CurrentConditions;

@RestController
public class WebController {
	
	private static Log log = LogFactory.getLog(WebController.class);
	
	@Autowired
	private ThreadPoolTaskScheduler scheduler;
	
	@Autowired
	private KafkaTemplate<String, CurrentConditions> kafkaTemplate;
	
	private Map<String, ScheduledFuture<?>> futures = new HashMap<>();
	
	@RequestMapping(
			value = "current",
			params = {"city"},
			method = RequestMethod.PUT
	)
	public void create(@RequestParam("city") String city) throws Exception {
		log.info("create city: " + city);
		CurrentWeatherGenerator generator = new CurrentWeatherGenerator(city, this.kafkaTemplate);
		this.futures.put(city, this.scheduler.scheduleAtFixedRate(generator, Duration.ofMillis(5000)));
	}

	@RequestMapping(
			value = "current",
			params = {"city"},
			method = RequestMethod.DELETE
	)
	public void delete(@RequestParam("city") String city) throws Exception {
		log.info("delete city: " + city);
		this.futures.get(city).cancel(true);
	}

}
