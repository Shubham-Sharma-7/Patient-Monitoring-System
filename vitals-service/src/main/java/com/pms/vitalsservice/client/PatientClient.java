package com.pms.vitalsservice.client;

import com.pms.vitalsservice.dto.PatientDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PatientClient {

    private final RestTemplate restTemplate;

    public PatientClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PatientDTO getPatientById(Long id) {
        return restTemplate.getForObject("http://patient-service:8081/api/patients/" + id, PatientDTO.class);
    }
}
