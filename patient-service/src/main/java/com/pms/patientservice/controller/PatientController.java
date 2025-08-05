package com.pms.patientservice.controller;

import com.pms.patientservice.dto.PatientDTO;
import com.pms.patientservice.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAll() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    @PostMapping
    public ResponseEntity<PatientDTO> create(@RequestBody PatientDTO dto) {
        return ResponseEntity.ok(patientService.createPatient(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> update(@PathVariable Long id, @RequestBody PatientDTO dto) {
        return ResponseEntity.ok(patientService.updatePatient(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}