package com.capg.campsite.service;

import java.time.LocalDate;
import java.util.List;

import com.capg.campsite.entity.Booking;
import com.capg.campsite.exception.ResourceNotFoundException;

public interface BookingService {
	public List<Booking> getAllBookings() throws ResourceNotFoundException;

	public Booking addBooking(Booking booking) throws Exception;

	public Booking getBookingById(long bookingId) throws ResourceNotFoundException;

	public Booking updateBooking(Booking booking) throws ResourceNotFoundException;

	public void deleteBooking(long bookingId) throws ResourceNotFoundException;

	public List<Booking> findAvailableBookings(LocalDate arrivalDate, LocalDate departureDate);

}
