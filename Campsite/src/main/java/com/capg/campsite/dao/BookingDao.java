package com.capg.campsite.dao;

import java.time.LocalDate;
import java.util.List;

import com.capg.campsite.entity.Booking;
import com.capg.campsite.exception.BookingDatesNotAvailableException;
import com.capg.campsite.exception.BookingDurationException;
import com.capg.campsite.exception.UserNotFoundException;

public interface BookingDao {
	public List<Booking> getAllBookings();
	public Booking addBooking(Booking booking)throws BookingDurationException,BookingDatesNotAvailableException;
	public Booking getBookingById(long bookingId) ;
	public Booking updateBooking(Booking booking );
	public void deleteBooking(long bookingId);
	public List<Booking> findAvailableBookings(LocalDate arrivalDate, LocalDate departureDate);

}
