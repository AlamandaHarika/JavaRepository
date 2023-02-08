package com.capg.campsite.dao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capg.campsite.entity.Booking;
import com.capg.campsite.entity.User;
import com.capg.campsite.exception.BookingDatesNotAvailableException;
import com.capg.campsite.exception.BookingDurationException;
import com.capg.campsite.exception.UserNotFoundException;
import com.capg.campsite.repository.BookingRepository;

@Service
public class BookingDaoImpl implements BookingDao{

    @Autowired
    BookingRepository repo;
	@Override
	public List<Booking> getAllBookings() {
		return repo.findAll();
	}

	@Override
	public Booking addBooking(Booking booking)throws BookingDurationException,BookingDatesNotAvailableException {
		Booking bookings;
		int duration = (int)ChronoUnit.DAYS.between(booking.getArrivalDate(), booking.getDepartureDate());
		if(duration>3||duration<1) {
			throw new BookingDurationException("Invalid booking duration. Booking should be between 1 to 3.");
		}
		else {
		bookings = repo.save(booking);
		}
		LocalDate today = LocalDate.now();
		if(ChronoUnit.DAYS.between(today, booking.getArrivalDate()) < 30) {
			throw new BookingDatesNotAvailableException("Booking dates not available. Booking should be made at least 1 month in advance.");
		}
		return booking;
	}

	@Override
	public Booking getBookingById(long bookingId)  {
		
		return repo.findById(bookingId).orElse(null);
	}


	

	@Override
	public Booking updateBooking(Booking booking) {

		return repo.save(booking);
	}

	@Override
	public void deleteBooking(long bookingId) {
		
		repo.deleteById(bookingId);
		}

	@Override
	public List<Booking> findAvailableBookings(LocalDate arrivalDate, LocalDate departureDate) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Booking> findAvailableBookings(LocalDate arrivalDate, LocalDate departureDate) {
////		TypedQuery<Booking> query = repo.createQuery("from Booking where arrivalDate >= :arrivalDate and departureDate <= :departureDate and availability = true", Booking.class);
////		query.setParameter("arrivalDate", arrivalDate);
////		query.setParameter("departureDate", departureDate);
//
//		return query.getResultList();
//	}
	
}
	