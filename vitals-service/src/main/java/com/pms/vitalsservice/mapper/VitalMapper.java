package com.pms.vitalsservice.mapper;

import com.pms.vitalsservice.dto.VitalDTO;
import com.pms.vitalsservice.entity.Vital;

public class VitalMapper {

    public static VitalDTO toDTO(Vital vital) {
        return VitalDTO.builder()
                .id(vital.getId())
                .temperature(vital.getTemperature())
                .heartRate(vital.getHeartRate())
                .systolicPressure(vital.getSystolicPressure())
                .diastolicPressure(vital.getDiastolicPressure())
                .recordedAt(vital.getRecordedAt())
                .patientId(vital.getPatientId())
                .build();
    }

    public static Vital toEntity(VitalDTO dto, Long patientId) {
        return Vital.builder()
                .temperature(dto.getTemperature())
                .heartRate(dto.getHeartRate())
                .systolicPressure(dto.getSystolicPressure())
                .diastolicPressure(dto.getDiastolicPressure())
                .recordedAt(dto.getRecordedAt())
                .patientId(patientId)
                .build();
    }
}
