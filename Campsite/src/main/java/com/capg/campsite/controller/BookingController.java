package com.capg.campsite.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.campsite.entity.Booking;
import com.capg.campsite.exception.ResourceNotFoundException;
import com.capg.campsite.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	private BookingService bookingService;

	@GetMapping("/all-bookings")
	public ResponseEntity<?> getAllBookings() throws ResourceNotFoundException {
		return ResponseEntity.ok(bookingService.getAllBookings());

	}

	@GetMapping("/get-booking-by-id/{bookingId}")
	public ResponseEntity<?> getBookingById(@PathVariable long bookingId) throws ResourceNotFoundException {

		return ResponseEntity.ok(bookingService.getBookingById(bookingId));
	}

	@PostMapping("/add-booking")
	public ResponseEntity<?> addBooking(@RequestBody Booking booking) throws Exception {
		return new ResponseEntity<>(bookingService.addBooking(booking), HttpStatus.CREATED);
	}

	@PutMapping("/update-booking")
	public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking) throws ResourceNotFoundException {

		return ResponseEntity.ok(bookingService.updateBooking(booking));
	}

	@DeleteMapping("/cancel-booking-by-id/{bookingId}")
	public ResponseEntity<?> cancelBooking(@PathVariable long bookingId) throws ResourceNotFoundException {
		bookingService.deleteBooking(bookingId);
		return new ResponseEntity<>("Booking canceled successfully", HttpStatus.OK);
	}

	@GetMapping("/findBookingsByArrivalAndDepartureDates")
	public ResponseEntity<?> findBookingsByArrivalAndDepartureDates(@PathVariable LocalDate arrivalDate,
			@PathVariable LocalDate departureDate) {

		return ResponseEntity.ok(bookingService.findAvailableBookings(arrivalDate, departureDate));

	}
}
