package com.health.care.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.health.care.db.HealthEntity;

@Repository
public interface HealthCareRepository extends JpaRepository<HealthEntity, Long>{

}
