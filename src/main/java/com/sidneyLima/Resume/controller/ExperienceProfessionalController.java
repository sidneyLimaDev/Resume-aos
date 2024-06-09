package com.sidneyLima.Resume.controller;


import com.sidneyLima.Resume.entity.ExperienceProfessional;
import com.sidneyLima.Resume.service.ExperienceProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experience-professional")
public class ExperienceProfessionalController {

    private final ExperienceProfessionalService experienceProfessionalService;

    @Autowired
    public ExperienceProfessionalController(ExperienceProfessionalService experienceProfessionalService) {
        this.experienceProfessionalService = experienceProfessionalService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExperienceProfessional> updateProfessionalExperience(@PathVariable Long id, @RequestBody ExperienceProfessional professionalExperience) {
        ExperienceProfessional updatedProfessionalExperience = experienceProfessionalService.updateExperienceProfessional(id, professionalExperience);
        return ResponseEntity.ok(updatedProfessionalExperience);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessionalExperience(@PathVariable Long id) {
        experienceProfessionalService.deleteExperienceProfessional(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienceProfessional> getExperienceProfessionalById(@PathVariable Long id) {
        ExperienceProfessional experienceProfessional = experienceProfessionalService.getExperienceProfessionalById(id);
        return ResponseEntity.ok(experienceProfessional);
    }

    @GetMapping("/")
    public ResponseEntity<List<ExperienceProfessional>> getAllExperiencesProfessional() {
        List<ExperienceProfessional> professionalExperiences = experienceProfessionalService.getAllExperienceProfessionals();
        return ResponseEntity.ok(professionalExperiences);
    }
}
