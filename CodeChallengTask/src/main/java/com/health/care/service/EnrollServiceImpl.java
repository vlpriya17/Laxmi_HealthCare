package com.health.care.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.health.care.db.EnrollDAO;
import com.health.care.db.EnrollDAOImpl;
import com.health.care.db.HealthEntity;
import com.health.care.sto.HealthDTO;

@Service
public class EnrollServiceImpl implements EnrollService{
	
    private static final Logger logger = LogManager.getLogger(EnrollServiceImpl.class);
	
    @Autowired
    private EnrollDAO enrollDAO;	
    
    @Autowired
    private ModelMapper modelMapper;  
    
	@Override
	public void saveHealthEnroll(HealthEntity healthEntity) {
		enrollDAO.saveHealthEnroll(healthEntity);
	}
	
    public HealthEntity enrollHealthCare(HealthDTO health){
    	HealthEntity convertToEntiry = convertToEntiry(health);
    	saveHealthEnroll(convertToEntiry);
    	logger.info("Inserted Successfully");
    	return convertToEntiry;
    }
    
    public HealthEntity convertToEntiry(HealthDTO health){
    	logger.info("Converting to Model");
    	HealthEntity post = modelMapper.map(health, HealthEntity.class);
    	logger.info("Values from Entity :: "+post);
		return post;
    }	
    
    public HealthEntity updateEnrollHealthCare(HealthDTO health){
    	HealthEntity convertToEntiry = convertToEntiry(health);
    	updateHealthEnroll(convertToEntiry,health);
    	logger.info("Updated Successfully");
    	return convertToEntiry;
    } 
    
	public void updateHealthEnroll(HealthEntity healthEntity,HealthDTO health) {
		enrollDAO.updateHealthEnroll(healthEntity,health);
	}
	
	@Override
	public String removeEnrollHealthCare(HealthDTO health) {
    	removeHealthEnroll(health.getId());
    	logger.info("Removed Successfully");
    	return "Enroll Removed "+health.getId()+" Successfully ";
	}
	
	public void removeHealthEnroll(Long id) {
		enrollDAO.removeHealthEnroll(id);
	}
    
}
