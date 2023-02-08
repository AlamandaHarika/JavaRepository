package com.capg.campsite.service;

import java.util.List;

import com.capg.campsite.entity.Campsite;
import com.capg.campsite.exception.ResourceNotFoundException;

public interface CampsiteService {
	public Campsite addCampsite(Campsite campsite) throws Exception;

	public Campsite updateCampsite(Campsite campsite) throws ResourceNotFoundException;

	public Campsite getCampsite(int siteId) throws ResourceNotFoundException;

	public List<Campsite> getCampsiteDetails() throws ResourceNotFoundException;

}
