package com.capg.campsite.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.campsite.entity.Booking;
import com.capg.campsite.exception.ResourceNotFoundException;
import com.capg.campsite.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;

	@Override
	public List<Booking> getAllBookings() throws ResourceNotFoundException {
		List<Booking> bookings = bookingRepository.findAll();
		if (bookings.isEmpty()) {
			throw new ResourceNotFoundException("Bookings Not Found in Data Base ");
		}
		return bookings;
	}

	@Override
	public Booking addBooking(Booking booking) throws Exception {
		if (bookingRepository.findById(booking.getBookingId()).isPresent()) {
			throw new Exception("Booking already Done with id " + booking.getBookingId());
		}
		return bookingRepository.save(booking);
	}

	@Override
	public Booking getBookingById(long bookingId) throws ResourceNotFoundException {

		return bookingRepository.findById(bookingId)
				.orElseThrow(() -> new ResourceNotFoundException("Booking not found with id : " + bookingId));
	}

	@Override
	public Booking updateBooking(Booking booking) throws ResourceNotFoundException {

		Booking b = bookingRepository.findById(booking.getBookingId()).orElseThrow(
				() -> new ResourceNotFoundException("Booking not found with id : " + booking.getBookingId()));
		bookingRepository.delete(b);

		return bookingRepository.save(booking);
	}

	@Override
	public void deleteBooking(long bookingId) throws ResourceNotFoundException {
		Booking b = bookingRepository.findById(bookingId)
				.orElseThrow(() -> new ResourceNotFoundException("Booking not found with id : " + bookingId));
		bookingRepository.delete(b);
	}

	@Override
	public List<Booking> findAvailableBookings(LocalDate arrivalDate, LocalDate departureDate) {

		return bookingRepository.findAll().stream()
				.filter(a -> a.getArrivalDate().equals(arrivalDate) && a.getDepartureDate().equals(departureDate))
				.collect(Collectors.toList());
	}

}
