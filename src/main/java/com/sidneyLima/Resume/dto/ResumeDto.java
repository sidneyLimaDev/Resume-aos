package com.sidneyLima.Resume.dto;

import jakarta.validation.Valid;

import java.util.List;

public record ResumeDto(
        InformationPersonalDto personalInformation,
        @Valid
        List<EducationAcademicDto> academicEducations,
        @Valid
        List<ExperienceProfessionalDto> professionalExperiences,
        @Valid
        List<HardSkillsDto> hardSkills
) {
}
