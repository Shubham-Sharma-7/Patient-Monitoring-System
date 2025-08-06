package com.pms.vitalsservice.service.impl;

import com.pms.vitalsservice.client.PatientClient;
import com.pms.vitalsservice.dto.VitalDTO;
import com.pms.vitalsservice.dto.PatientDTO;
import com.pms.vitalsservice.entity.Vital;
import com.pms.vitalsservice.mapper.VitalMapper;
import com.pms.vitalsservice.repository.VitalRepository;
import com.pms.vitalsservice.service.VitalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VitalServiceImpl implements VitalService {

    private final VitalRepository vitalRepository;
    private final PatientClient patientClient;

    public VitalServiceImpl(VitalRepository vitalRepository, PatientClient patientClient) {
        this.vitalRepository = vitalRepository;
        this.patientClient = patientClient;
    }

    @Override
    public List<VitalDTO> getVitalsByPatientId(Long patientId) {
        return vitalRepository.findByPatientId(patientId)
                .stream()
                .map(VitalMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VitalDTO saveVital(VitalDTO dto) {
        PatientDTO patient = patientClient.getPatientById(dto.getPatientId());
        Vital vital = VitalMapper.toEntity(dto, patient.getId());
        Vital saved = vitalRepository.save(vital);
        return VitalMapper.toDTO(saved);
    }
}
