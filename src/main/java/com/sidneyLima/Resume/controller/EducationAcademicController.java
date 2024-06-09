package com.sidneyLima.Resume.controller;


import com.sidneyLima.Resume.entity.EducationAcademic;
import com.sidneyLima.Resume.service.EducationAcademicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/education-academic")
public class EducationAcademicController {

    private final EducationAcademicService educationsAcademicService;

    @Autowired
    public EducationAcademicController(EducationAcademicService educationsAcademicService) {
        this.educationsAcademicService = educationsAcademicService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<EducationAcademic> updateEducationsAcademic(@PathVariable Long id, @RequestBody EducationAcademic educationsAcademic) {
        EducationAcademic updatedEducationsAcademic = educationsAcademicService.updateEducationAcademic(id, educationsAcademic);
        return ResponseEntity.ok(updatedEducationsAcademic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducationsAcademic(@PathVariable Long id) {
        educationsAcademicService.deleteEducationAcademic(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducationAcademic> getEducationsAcademicById(@PathVariable Long id) {
        EducationAcademic educationAcademic = educationsAcademicService.getEducationAcademicById(id);
        return ResponseEntity.ok(educationAcademic);
    }

    @GetMapping("/")
    public ResponseEntity<List<EducationAcademic>> getAllEducationsAcademic() {
        List<EducationAcademic> educationsAcademics = educationsAcademicService.getAllEducationAcademic();
        return ResponseEntity.ok(educationsAcademics);
    }
}
