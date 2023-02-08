package com.capg.campsite.dao;

import java.util.List;

import com.capg.campsite.entity.Campsite;

public interface CampsiteDao {
	public Campsite addCampsite(Campsite campsite);
	public Campsite updateCampsite(Campsite campsite);
	public Campsite getCampsite(int siteId);
	public List <Campsite> getCampsiteDetails();
	

}
