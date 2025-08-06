package com.pms.vitalsservice.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VitalDTO {
    private Long id;
    private Double temperature;
    private Integer heartRate;
    private Integer systolicPressure;
    private Integer diastolicPressure;
    private LocalDateTime recordedAt;
    private Long patientId;
}
