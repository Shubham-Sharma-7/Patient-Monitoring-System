package com.pms.patientservice.dto;

import lombok.*;
import com.pms.patientservice.entity.enums.Gender;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private Long id;
    private String name;
    private Integer age;
    private Gender gender;
    private String email;
}
