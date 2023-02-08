package com.capg.campsite.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Campsite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int siteId;
	private boolean drinkingWater;
	private boolean firePit;
	private int capacity;
	private boolean campsiteTent;
	private boolean availability;
	private boolean restrooms;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "booking_fk", referencedColumnName = "bookingId")
	private Booking booking;

	public Campsite() {
		super();
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public boolean isDrinkingWater() {
		return drinkingWater;
	}

	public void setDrinkingWater(boolean drinkingWater) {
		this.drinkingWater = drinkingWater;
	}

	public boolean isFirePit() {
		return firePit;
	}

	public void setFirePit(boolean firePit) {
		this.firePit = firePit;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isCampsiteTent() {
		return campsiteTent;
	}

	public void setCampsiteTent(boolean campsiteTent) {
		this.campsiteTent = campsiteTent;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public boolean isRestrooms() {
		return restrooms;
	}

	public void setRestrooms(boolean restrooms) {
		this.restrooms = restrooms;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Campsite(int siteId, boolean drinkingWater, boolean firePit, int capacity, boolean campsiteTent,
			boolean availability, boolean restrooms, Booking booking) {
		super();
		this.siteId = siteId;
		this.drinkingWater = drinkingWater;
		this.firePit = firePit;
		this.capacity = capacity;
		this.campsiteTent = campsiteTent;
		this.availability = availability;
		this.restrooms = restrooms;
		this.booking = booking;
	}
	

}
