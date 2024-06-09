package com.sidneyLima.Resume.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import com.sidneyLima.Resume.dto.ResumeDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "resumes")
@NoArgsConstructor
@AllArgsConstructor
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "resume")
    @JsonManagedReference
    private InformationPersonal informationPersonal;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resume")
    @JsonManagedReference
    private List<ExperienceProfessional> experienceProfessionals;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resume")
    @JsonManagedReference
    private List<HardSkills> hardSkills;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resume")
    @JsonManagedReference
    private List<EducationAcademic> educationAcademics;

    public Resume(ResumeDto resumeDto) {
        this.informationPersonal = new InformationPersonal(resumeDto.personalInformation());
        informationPersonal.setResume(this);
        this.experienceProfessionals = resumeDto.professionalExperiences().stream().map(exp -> {
            ExperienceProfessional experienceProfessional = new ExperienceProfessional(exp);
            experienceProfessional.setResume(this);
            return experienceProfessional;
        }).collect(Collectors.toList());
        this.hardSkills = resumeDto.hardSkills().stream().map(c -> {
            HardSkills hardSkills = new HardSkills(c);
            hardSkills.setResume(this);
            return hardSkills;
        }).collect(Collectors.toList());
        this.educationAcademics = resumeDto.academicEducations().stream().map(f -> {
            EducationAcademic educationAcademic = new EducationAcademic(f);
            educationAcademic.setResume(this);
            return educationAcademic;
        }).collect(Collectors.toList());
    }

    public void updateFromDto(ResumeDto resumeDto) {
        this.setInformationPersonal(new InformationPersonal(resumeDto.personalInformation()));
    }
}
