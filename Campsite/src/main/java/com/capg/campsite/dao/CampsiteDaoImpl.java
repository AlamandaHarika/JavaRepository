package com.capg.campsite.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capg.campsite.entity.Campsite;
import com.capg.campsite.repository.CampsiteRepository;
@Service
public class CampsiteDaoImpl implements CampsiteDao {
//	@PersistenceContext
//	EntityManager entityManager;
	@Autowired
	CampsiteRepository repo;

	@Override
	public Campsite addCampsite(Campsite campsite) {
//		entityManager.persist(campsite);
		return repo.save(campsite);
	}

	@Override
	public Campsite updateCampsite(Campsite campsite) {
//		entityManager.merge(campsite);
		return repo.save(campsite);
	}

	@Override
	public Campsite getCampsite(int siteId) {
//		 return entityManager.find(Campsite.class, siteId);
		return repo.findById(siteId).orElse(null);
	}

	@Override
	public List <Campsite> getCampsiteDetails() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}

