package com.pms.patientservice.mapper;

import com.pms.patientservice.dto.PatientDTO;
import com.pms.patientservice.entity.Patient;

public class PatientMapper {

    public static PatientDTO toDTO(Patient patient) {
        return new PatientDTO(
                patient.getId(),
                patient.getName(),
                patient.getAge(),
                patient.getGender(),
                patient.getEmail()
        );
    }

    public static Patient toEntity(PatientDTO dto) {
        return new Patient(
                dto.getId(),
                dto.getName(),
                dto.getAge(),
                dto.getGender(),
                dto.getEmail()
        );
    }
}