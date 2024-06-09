package com.sidneyLima.Resume.controller;


import com.sidneyLima.Resume.dto.EducationAcademicDto;
import com.sidneyLima.Resume.dto.ExperienceProfessionalDto;
import com.sidneyLima.Resume.dto.HardSkillsDto;
import com.sidneyLima.Resume.dto.ResumeDto;
import com.sidneyLima.Resume.entity.Resume;
import com.sidneyLima.Resume.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    private final ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping("/")
    public ResponseEntity<Resume> createResume(@RequestBody ResumeDto resumeDto) {
        Resume createdResume = resumeService.createResume(resumeDto);
        return ResponseEntity.ok(createdResume);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resume> updateResume(@PathVariable Long id, @RequestBody ResumeDto resumeDto) {
        Resume updatedResume = resumeService.updateResume(id, resumeDto);
        return ResponseEntity.ok(updatedResume);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResume(@PathVariable Long id) {
        resumeService.deleteResume(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resume> getResumeById(@PathVariable Long id) {
        Resume resume = resumeService.getResumeById(id);
        return ResponseEntity.ok(resume);
    }

    @GetMapping("/")
    public ResponseEntity<List<Resume>> getAllResumes() {
        List<Resume> resumes = resumeService.getAllResumes();
        return ResponseEntity.ok(resumes);
    }

    @PostMapping("/{id}/add-academic-education")
    public ResponseEntity<Resume> addAcademicFormation(@PathVariable Long id, @RequestBody EducationAcademicDto educationAcademicDto) {
        Resume updatedResume = resumeService.addAcademicFormation(id, educationAcademicDto);
        return ResponseEntity.ok(updatedResume);
    }

    @PostMapping("/{id}/add-hard-skill")
    public ResponseEntity<Resume> addHardSkill(@PathVariable Long id, @RequestBody HardSkillsDto hardSkillsDto) {
        Resume updatedResume = resumeService.addHardSkill(id, hardSkillsDto);
        return ResponseEntity.ok(updatedResume);
    }

    @PostMapping("/{id}/add-professional-experience")
    public ResponseEntity<Resume> addProfessionalExperience(@PathVariable Long id, @RequestBody ExperienceProfessionalDto professionalExperienceDto) {
        Resume updatedResume = resumeService.addProfessionalExperience(id, professionalExperienceDto);
        return ResponseEntity.ok(updatedResume);
    }
}
