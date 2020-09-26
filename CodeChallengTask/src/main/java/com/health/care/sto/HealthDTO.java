package com.health.care.sto;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.health.care.db.Dependents;

@Component
public class HealthDTO{

    private Long id;
    private String name;
    private Boolean activationStatus;
    private List<Dependents> dependents;
    private String phoneNumber;
    private String dateOfBirth;
    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getActivationStatus() {
		return activationStatus;
	}

	public void setActivationStatus(Boolean activationStatus) {
		this.activationStatus = activationStatus;
	}

	public List<Dependents> getDependents() {
		return dependents;
	}

	public void setDependents(List<Dependents> dependents) {
		this.dependents = dependents;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "HealthDTO [id=" + id + ", name=" + name + ", activationStatus="
				+ activationStatus + ", dependents=" + dependents
				+ ", phoneNumber=" + phoneNumber + ", dateOfBirth="
				+ dateOfBirth + "]";
	}  
}


