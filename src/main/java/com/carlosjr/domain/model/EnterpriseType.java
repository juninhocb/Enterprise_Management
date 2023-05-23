package com.carlosjr.domain.model;

public enum EnterpriseType {
	
	MEI("Microempreendedor Individual"), 
	EIRELI("Empresa Individual de Responsabilidade Limitada"),
	LTDA("Sociedade Limitada"),
	SA("Sociedade Anônima");
	
	private String description;

	EnterpriseType(String descritpion) {
		this.description = descritpion;
	}
	
	public String getDescricao() {
		return description;
	}

}
