package com.pms.vitalsservice.dto;

import lombok.Data;

@Data
public class PatientDTO {
    private Long id;
    private String name;
    private Integer age;
    private String gender;
    private String email;
}
