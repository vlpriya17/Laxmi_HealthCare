package com.health.care.starter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.health.care.db.HealthEntity;
import com.health.care.service.EnrollService;
import com.health.care.sto.HealthDTO;

@RestController
public class EnrollController {
	
    private static final Logger logger = LogManager.getLogger(EnrollController.class);
	
    @Autowired
    private EnrollService enrollService;	
    
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value="/enrollHealthCare", headers="Accept=application/json")
    public ResponseEntity<HealthEntity> enrollHealthCare(@RequestBody HealthDTO health) {
        return new ResponseEntity<>(enrollService.enrollHealthCare(health), HttpStatus.OK);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value="/modifyEnrollHealthCare", headers="Accept=application/json")
    public ResponseEntity<Object> modifyEnrollHealthCare(@RequestBody HealthDTO health) {
        return new ResponseEntity<>(enrollService.updateEnrollHealthCare(health), HttpStatus.OK);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value="/removeEnrollHealthCare", headers="Accept=application/json")
    public ResponseEntity<Object> removeEnrollHealthCare(@RequestBody HealthDTO health) {
        return new ResponseEntity<>(enrollService.removeEnrollHealthCare(health), HttpStatus.OK);
    }
    
}
