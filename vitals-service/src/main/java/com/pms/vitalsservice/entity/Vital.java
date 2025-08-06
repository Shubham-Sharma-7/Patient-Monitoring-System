package com.pms.vitalsservice.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "vitals")
public class Vital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double temperature;
    private Integer heartRate;
    private Integer systolicPressure;
    private Integer diastolicPressure;
    private LocalDateTime recordedAt;

    @Column(name = "patient_id", nullable = false)
    private Long patientId;
}
