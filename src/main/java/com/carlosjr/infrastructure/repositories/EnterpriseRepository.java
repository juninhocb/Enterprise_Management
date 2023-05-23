package com.carlosjr.infrastructure.repositories;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.carlosjr.domain.model.Enterprise;

public class EnterpriseRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager _manager;

	public EnterpriseRepository() {

	}

	public EnterpriseRepository(EntityManager manager) {
		this._manager = manager;
	}

	public Enterprise findById(Long id) {
		return _manager.find(Enterprise.class, id);
	}

	public List<Enterprise> findByName(String name) {
		String jpql = "from Enterprise where fantasyName like :fantasyName";
		
		TypedQuery<Enterprise> query = _manager
				.createQuery(jpql, Enterprise.class);
		
		query.setParameter("fantasyName", name + "%");
		
		return query.getResultList();
	}

	public Enterprise save(Enterprise enterprise) {
		return _manager.merge(enterprise);
	}

	public void remove(Enterprise enterprise) {
		enterprise = findById(enterprise.getId());
		_manager.remove(enterprise);
	}
}