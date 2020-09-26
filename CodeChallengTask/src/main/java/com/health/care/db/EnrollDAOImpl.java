package com.health.care.db;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.health.care.service.HealthCareRepository;
import com.health.care.sto.HealthDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Repository
@Transactional
public class EnrollDAOImpl implements EnrollDAO {
	
    private static final Logger logger = LogManager.getLogger(EnrollDAOImpl.class);

	
	private final HealthCareRepository healthCareRepository;
	
	public EnrollDAOImpl(HealthCareRepository healthCareRepository) {
		this.healthCareRepository = healthCareRepository;
	}

	public void saveHealthEnroll(HealthEntity healthEntity) {
		healthCareRepository.save(healthEntity);
        logger.info("Saved Successfully");
	}
	
	public void updateHealthEnroll(HealthEntity healthEntity,HealthDTO health) {
		HealthEntity customerToUpdate = healthCareRepository.getOne(health.getId());
		HealthEntity updateHealthEntity = updateHealthEntity(customerToUpdate, health);
		healthCareRepository.save(updateHealthEntity);
        logger.info("Updated Successfully");
	}
	
	private HealthEntity updateHealthEntity(HealthEntity customerToUpdate,
			HealthDTO health) {
		customerToUpdate.setDateOfBirth(health.getDateOfBirth());
		customerToUpdate.setName(health.getName());
		customerToUpdate.setPhoneNumber(health.getPhoneNumber());
		customerToUpdate.setActivationStatus(health.getActivationStatus());
		customerToUpdate.setDependents(health.getDependents());
		return customerToUpdate;
		
	}

	public void removeHealthEnroll(Long id) {
		HealthEntity customerToUpdate = healthCareRepository.getOne(id);
		healthCareRepository.delete(customerToUpdate);
        logger.info("Removed  Successfully");
		
	}

}
