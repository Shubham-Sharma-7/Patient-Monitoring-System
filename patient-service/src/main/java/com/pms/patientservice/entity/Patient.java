package com.pms.patientservice.entity;

import jakarta.persistence.*;
import com.pms.patientservice.entity.enums.Gender;
import lombok.*;

@Entity
@Table(name = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String email;
}