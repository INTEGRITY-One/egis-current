package com.ionep.egis.current.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class Wind {
	
	private long id;
	
	@NonNull
	private int dir;
	
	@NonNull
	private int speed;
	
	public Wind() {
	}
	
	public Wind(int dir, int speed) {
		this.dir = dir;
		this.speed = speed;
	}
	
	public Wind from(Wind wind) {
		this.dir = wind.dir;
		this.speed = wind.speed;
		return this;
	}
	
	public int getDir() {
		return this.dir;
	}
	
	public void setDir(int dir) {
		this.dir = dir;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
