package com.pms.vitalsservice.repository;

import com.pms.vitalsservice.entity.Vital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VitalRepository extends JpaRepository<Vital, Long> {
    List<Vital> findByPatientId(Long patientId);
}
