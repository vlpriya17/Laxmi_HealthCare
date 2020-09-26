package com.health.care.service;

import com.health.care.db.HealthEntity;
import com.health.care.sto.HealthDTO;

public interface EnrollService {
	
    public void saveHealthEnroll(HealthEntity healthEntity);
    
    public HealthEntity enrollHealthCare(HealthDTO health);

	public Object updateEnrollHealthCare(HealthDTO health);

	public Object removeEnrollHealthCare(HealthDTO health);
    
}
