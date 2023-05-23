package com.carlosjr.domain.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "enterprise")
public class Enterprise implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fantasy_name", nullable = false, length = 80)
	private String fantasyName;
	
	@Column(name = "social_name", nullable = false, length = 120)
	private String socialName;
	
	@Column(nullable = false, length = 18)
	private String identity;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "created_date")
	private Date createdDate;
	
	@ManyToOne
	@JoinColumn(name = "description_activity_id", nullable = false)
	private DescActivity descriptionActivity;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
	private EnterpriseType enterpriseType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFantasyName() {
		return fantasyName;
	}

	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}

	public String getSocialName() {
		return socialName;
	}

	public void setSocialName(String socialName) {
		this.socialName = socialName;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public DescActivity getDescriptionActivity() {
		return descriptionActivity;
	}

	public void setDescriptionActivity(DescActivity descriptionActivity) {
		this.descriptionActivity = descriptionActivity;
	}

	public EnterpriseType getEnterpriseType() {
		return enterpriseType;
	}

	public void setEnterpriseType(EnterpriseType enterpriseType) {
		this.enterpriseType = enterpriseType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enterprise other = (Enterprise) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Enterprise [id=" + id + "]";
	}	
}