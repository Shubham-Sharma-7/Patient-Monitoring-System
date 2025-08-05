package com.pms.patientservice.service;

import com.pms.patientservice.dto.PatientDTO;
import java.util.List;

public interface PatientService {
    List<PatientDTO> getAllPatients();
    PatientDTO getPatientById(Long id);
    PatientDTO createPatient(PatientDTO dto);
    PatientDTO updatePatient(Long id, PatientDTO dto);
    void deletePatient(Long id);
}