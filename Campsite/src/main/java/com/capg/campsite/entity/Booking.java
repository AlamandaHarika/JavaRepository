package com.capg.campsite.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookingId;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate arrivalDate;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate departureDate;
	private boolean availability;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_fk", referencedColumnName = "userId")
	private User user;

	public Booking() {
		super();
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Booking(long bookingId, LocalDate arrivalDate, LocalDate departureDate, boolean availability, User user) {
		super();
		this.bookingId = bookingId;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.availability = availability;
		this.user = user;
	}

}
