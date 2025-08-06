package com.pms.vitalsservice.controller;

import com.pms.vitalsservice.dto.VitalDTO;
import com.pms.vitalsservice.service.VitalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vitals")
public class VitalController {

    private final VitalService vitalService;

    public VitalController(VitalService vitalService) {
        this.vitalService = vitalService;
    }

    @PostMapping
    public VitalDTO recordVital(@RequestBody VitalDTO vitalDTO) {
        return vitalService.saveVital(vitalDTO);
    }

    @GetMapping("/patient/{patientId}")
    public List<VitalDTO> getVitalsByPatient(@PathVariable Long patientId) {
        return vitalService.getVitalsByPatientId(patientId);
    }
}
