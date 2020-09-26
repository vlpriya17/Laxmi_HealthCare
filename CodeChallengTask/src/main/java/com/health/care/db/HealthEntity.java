package com.health.care.db;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import org.springframework.stereotype.Component;

@Entity(name = "enroll")
@Table(name = "enroll", schema = "public")
@Component
/*@OptimisticLocking(type = OptimisticLockType.VERSION)
@DynamicUpdate*/
public class HealthEntity implements Serializable {
	
    /**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = -749846799119457859L;

	@Id
    @Column(name = "health_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "activationStatus", nullable = false)
    private Boolean activationStatus;
    
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="health_id", referencedColumnName="health_id")
	private List<Dependents> dependents;    
    
    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;
    
    @Basic
    @Column(name = "dob", nullable = false)
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
	public HealthEntity(Long id, String name, Boolean activationStatus,
			List<Dependents> dependents, String phoneNumber, String dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.activationStatus = activationStatus;
		this.dependents = dependents;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}