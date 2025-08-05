package com.pms.patientservice.service;

import com.pms.patientservice.dto.PatientDTO;
import com.pms.patientservice.entity.Patient;
import com.pms.patientservice.exception.ResourceNotFoundException;
import com.pms.patientservice.mapper.PatientMapper;
import com.pms.patientservice.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(PatientMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PatientDTO getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));
        return PatientMapper.toDTO(patient);
    }

    @Override
    public PatientDTO createPatient(PatientDTO dto) {
        Patient patient = PatientMapper.toEntity(dto);
        return PatientMapper.toDTO(patientRepository.save(patient));
    }

    @Override
    public PatientDTO updatePatient(Long id, PatientDTO dto) {
        Patient existing = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));

        if (dto.getName() != null) {
            existing.setName(dto.getName());
        }
        if (dto.getAge() != null) {
            existing.setAge(dto.getAge());
        }
        if (dto.getGender() != null) {
            existing.setGender(dto.getGender());
        }
        if (dto.getEmail() != null) {
            existing.setEmail(dto.getEmail());
        }

        return PatientMapper.toDTO(patientRepository.save(existing));
    }

    @Override
    public void deletePatient(Long id) {
        Patient existing = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));
        patientRepository.delete(existing);
    }
}
