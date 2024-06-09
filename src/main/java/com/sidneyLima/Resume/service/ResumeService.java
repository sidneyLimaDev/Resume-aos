package com.sidneyLima.Resume.service;


import com.sidneyLima.Resume.dto.EducationAcademicDto;
import com.sidneyLima.Resume.dto.ExperienceProfessionalDto;
import com.sidneyLima.Resume.dto.HardSkillsDto;
import com.sidneyLima.Resume.dto.ResumeDto;
import com.sidneyLima.Resume.entity.EducationAcademic;
import com.sidneyLima.Resume.entity.ExperienceProfessional;
import com.sidneyLima.Resume.entity.HardSkills;
import com.sidneyLima.Resume.entity.Resume;
import com.sidneyLima.Resume.exception.ObjectNotFound;
import com.sidneyLima.Resume.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeService {
    private final ResumeRepository resumeRepository;

    @Autowired
    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    public Resume createResume(ResumeDto resumeDto) {
        Resume resume = new Resume(resumeDto);
        return resumeRepository.save(resume);
    }

    public Resume updateResume(Long id, ResumeDto resumeDto) {
        Resume resume = resumeRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Resume not found with id: " + id));
        resume.updateFromDto(resumeDto);
        return resumeRepository.save(resume);
    }

    public void deleteResume(Long id) {
        resumeRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Resume not found with id: " + id));
        resumeRepository.deleteById(id);
    }

    public Resume getResumeById(Long id) {
        return resumeRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Resume not found with id: " + id));
    }

    public List<Resume> getAllResumes() {
        var resumes = resumeRepository.findAll();
        if (resumes.isEmpty()) {
            throw new ObjectNotFound("No resume found");
        }
        return resumes;
    }


    public Resume addAcademicFormation(Long resumeId, EducationAcademicDto academicEducationDto) {
        Resume resume = resumeRepository.findById(resumeId).orElseThrow(() -> new ObjectNotFound("Resume not found with id: " + resumeId));
        EducationAcademic educationAcademic = new EducationAcademic(academicEducationDto);
        educationAcademic.setResume(resume);
        resume.getEducationAcademics().add(educationAcademic);
        return resumeRepository.save(resume);
    }

    public Resume addHardSkill(Long resumeId, HardSkillsDto hardSkillsDto) {
        Resume resume = resumeRepository.findById(resumeId).orElseThrow(() -> new ObjectNotFound("Resume not found with id: " + resumeId));
        HardSkills hardSkills = new HardSkills(hardSkillsDto);
        hardSkills.setResume(resume);
        resume.getHardSkills().add(hardSkills);
        return resumeRepository.save(resume);
    }

    public Resume addProfessionalExperience(Long resumeId, ExperienceProfessionalDto experienceProfessionalDto) {
        Resume resume = resumeRepository.findById(resumeId).orElseThrow(() -> new ObjectNotFound("Resume not found with id: " + resumeId));
        ExperienceProfessional experienceProfessional = new ExperienceProfessional(experienceProfessionalDto);
        experienceProfessional.setResume(resume);
        resume.getExperienceProfessionals().add(experienceProfessional);
        return resumeRepository.save(resume);
    }
}
