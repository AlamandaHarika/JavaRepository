package com.capg.campsite.exception;

public class BookingDurationException extends Exception {
	private String message;
	public BookingDurationException() {}
	public BookingDurationException(String message) {
		this.message=message;
	}
	public String getMessage(){
		return this.message;
	}

}
