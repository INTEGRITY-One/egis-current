package com.ionep.egis.current.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class City {
	
	private long id;
	
	@NonNull
	private String name;

	public City() {
	}
	
	public City(String name) {
		this.name = name;
	}
	
	public City from(City city) {
		this.name = city.name;
		return this;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
