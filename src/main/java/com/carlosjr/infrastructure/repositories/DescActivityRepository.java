package com.carlosjr.infrastructure.repositories;

import com.carlosjr.domain.model.DescActivity;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.io.Serializable;
import java.util.List;

public class DescActivityRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager _manager;

	public DescActivityRepository() {

	}

	public DescActivityRepository(EntityManager manager) {
		this._manager = manager;
	}
	
	public List<DescActivity> findByDescription(String description) {
		CriteriaBuilder criteriaBuilder = _manager.getCriteriaBuilder();
		
		CriteriaQuery<DescActivity> criteriaQuery = criteriaBuilder.createQuery(DescActivity.class);		
		Root<DescActivity> root = criteriaQuery.from(DescActivity.class);			
		criteriaQuery.select(root);				
		criteriaQuery.where(criteriaBuilder.like(root.get("description"), description + "%"));		
		
		TypedQuery<DescActivity> query = _manager.createQuery(criteriaQuery);
		
		return query.getResultList();
	}
}

