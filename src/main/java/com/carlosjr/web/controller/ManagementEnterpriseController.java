package com.carlosjr.web.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.carlosjr.domain.model.Enterprise;
import com.carlosjr.domain.model.EnterpriseType;

@Named
@ViewScoped
public class ManagementEnterpriseController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Enterprise enterprise = new Enterprise();
	
	public void save() {
		System.out.println("Razão social: " + enterprise.getSocialName()
        + " - Nome fantasia: " + enterprise.getFantasyName()
        + " - Tipo: " + enterprise.getEnterpriseType().getDescription());
    }
    
    public String help() {
        return "AjudaGestaoEmpresas?faces-redirect=true";
    }
    
    
    public Enterprise getEnterprise() {
        return enterprise;
    }
    
    public EnterpriseType[] getTypesEnterprise() {
        return EnterpriseType.values();
    }
	
	
	

}
