package com.health.care.db;

import com.health.care.sto.HealthDTO;

public interface EnrollDAO {

    public void saveHealthEnroll(HealthEntity healthEntity);
    
	void updateHealthEnroll(HealthEntity healthEntity,HealthDTO health);

	public void removeHealthEnroll(Long id);

}

