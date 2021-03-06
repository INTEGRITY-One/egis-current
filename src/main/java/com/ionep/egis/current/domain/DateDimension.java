package com.ionep.egis.current.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.IsoFields;
import java.util.Locale;

import lombok.Data;
import lombok.NonNull;

@Data
public class DateDimension {
	
	private long id;
	
	@NonNull
	private String date;
	
	@NonNull
	private String hour;
	
	@NonNull
	private String month;
	
	@NonNull
	private String year;
	
	@NonNull
	private String dayOfMonth;
	
	@NonNull
	private String dayOfWeek;
	
	@NonNull
	private String weekOfYear;
	
	public DateDimension() {
	}
	
	public DateDimension(LocalDateTime timestamp) {
		this.date = DateTimeFormatter.BASIC_ISO_DATE.format(timestamp);
		this.hour = String.format("%02d", timestamp.getHour());
		this.month = timestamp.getMonth().getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase();
		this.year = String.format("%4d", timestamp.getYear());
		this.dayOfMonth = String.format("%02d", timestamp.getDayOfMonth());
		this.dayOfWeek = timestamp.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase();
		this.weekOfYear = String.format("%02d", timestamp.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR));
	}
	
	public DateDimension from(DateDimension date) {
		this.date = date.date;
		this.hour = date.hour;
		this.month = date.month;
		this.year = date.year;
		this.dayOfMonth = date.dayOfMonth;
		this.dayOfWeek = date.dayOfWeek;
		this.weekOfYear = date.weekOfYear;
		return this;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMonth() {
		return this.month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDayOfMonth() {
		return this.dayOfMonth;
	}

	public void setDayOfMonth(String dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}

	public String getDayOfWeek() {
		return this.dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getWeekOfYear() {
		return this.weekOfYear;
	}

	public void setWeekOfYear(String weekOfYear) {
		this.weekOfYear = weekOfYear;
	}

	public String getHour() {
		return this.hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

}
