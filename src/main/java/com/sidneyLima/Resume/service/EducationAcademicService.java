package com.sidneyLima.Resume.service;


import com.sidneyLima.Resume.entity.EducationAcademic;
import com.sidneyLima.Resume.exception.ObjectNotFound;
import com.sidneyLima.Resume.repository.EducationAcademicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationAcademicService {
    private final EducationAcademicRepository educationAcademicRepository;

    @Autowired
    public EducationAcademicService(EducationAcademicRepository educationAcademicRepository) {
        this.educationAcademicRepository = educationAcademicRepository;
    }

    public EducationAcademic updateEducationAcademic(Long id, EducationAcademic educationAcademic) {
        if (!educationAcademicRepository.existsById(id)) {
            throw new ObjectNotFound("Academic education not found with id: " + id);
        }
        educationAcademic.setId(id);
        return educationAcademicRepository.save(educationAcademic);
    }

    public void deleteEducationAcademic(Long id) {
        if (!educationAcademicRepository.existsById(id)) {
            throw new ObjectNotFound("Academic education not found with id: " + id);
        }
        educationAcademicRepository.deleteById(id);
    }

    public EducationAcademic getEducationAcademicById(Long id) {
        return educationAcademicRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Academic education not found with id: " + id));
    }

    public List<EducationAcademic> getAllEducationAcademic() {
        List<EducationAcademic> educationsAcademic = educationAcademicRepository.findAll();
        if (educationsAcademic.isEmpty()) {
            throw new ObjectNotFound("No academic education found");
        }
        return educationsAcademic;
    }

}
