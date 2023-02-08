package com.capg.campsite.exception;

public class BookingDatesNotAvailableException extends Exception {
	private String message;
	public BookingDatesNotAvailableException() {}
	public BookingDatesNotAvailableException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return this.message;
	}

}
