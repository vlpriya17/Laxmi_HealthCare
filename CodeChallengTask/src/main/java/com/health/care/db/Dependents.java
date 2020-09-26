package com.health.care.db;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.stereotype.Component;

@Entity(name = "dependent")
@Table(name = "dependent", schema = "public")
@Component
/*@OptimisticLocking(type = OptimisticLockType.ALL)
@DynamicUpdate*/
public class Dependents implements Serializable{
	
    public Dependents(Integer dependentId, String name, String dateOfBirth) {
		super();
		this.dependentId = dependentId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 *  Generated serialVersionUID
	 */
	private static final long serialVersionUID = -6385910969078901067L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer dependentId;
	
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "dob", nullable = false)
    private String dateOfBirth;
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Integer getDependentId() {
		return dependentId;
	}

	public void setDependentId(Integer dependentId) {
		this.dependentId = dependentId;
	}

}
