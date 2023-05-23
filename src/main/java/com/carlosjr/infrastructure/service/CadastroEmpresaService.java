package com.carlosjr.infrastructure.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.carlosjr.domain.model.Enterprise;
import com.carlosjr.infrastructure.repositories.EnterpriseRepository;
import com.carlosjr.infrastructure.util.Transacional;

public class CadastroEmpresaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EnterpriseRepository _enterpriseRepository;

    @Transacional
    public void save(Enterprise enterprise) {
    	_enterpriseRepository.save(enterprise);
    }

    @Transacional
    public void remove(Enterprise enterprise) {
    	_enterpriseRepository.remove(enterprise);
    }

}