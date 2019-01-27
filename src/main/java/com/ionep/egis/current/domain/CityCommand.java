package com.ionep.egis.current.domain;

//import lombok.Data;

//@Data
public class CityCommand {
	
	private String city;
	
	private String command;
	
	public String getCity() {
		return this.city;
	}
	
	public String getCommand() {
		return this.command;
	}
	
	public CityCommand(String city) {
		this(city, null);
	}
	
	public CityCommand(String city, String command) {
		this.city = city;
		this.command = command;
	}

}
