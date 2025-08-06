package com.pms.vitalsservice.service;

import com.pms.vitalsservice.dto.VitalDTO;

import java.util.List;

public interface VitalService {
    VitalDTO saveVital(VitalDTO dto);
    List<VitalDTO> getVitalsByPatientId(Long patientId);
}
