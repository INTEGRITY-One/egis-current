package com.ionep.egis.current.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
	
	private static Log log = LogFactory.getLog(WebController.class);
	
	@RequestMapping(
			value = "current",
			params = {"city"},
			method = RequestMethod.PUT
	)
	public void create(@RequestParam("city") String city) throws Exception {
		log.info("city: " + city);
	}

	@RequestMapping(
			value = "current",
			params = {"city"},
			method = RequestMethod.DELETE
	)
	public void delete(@RequestParam("city") String city) throws Exception {
		log.info("city: " + city);
	}

	@RequestMapping(
			value = "current",
			params = {"city", "command"},
			method = RequestMethod.POST
	)
	public void suspendOrResult(@RequestParam("city") String city, @RequestParam("command") String command) throws Exception {
		log.info("city: " + city + ", command: " + command);
	}

}
