package com.sidneyLima.Resume.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sidneyLima.Resume.dto.EducationAcademicDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "academic_educations")
@NoArgsConstructor
@AllArgsConstructor
public class EducationAcademic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String course;

    @Column(nullable = false)
    private String institution;

    @Column(nullable = false)
    private String startDate;

    private String endDate;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    @JsonBackReference
    private Resume resume;

    public EducationAcademic(EducationAcademicDto academicEducationDto) {
        this.course = academicEducationDto.course();
        this.institution = academicEducationDto.institution();
        this.startDate = academicEducationDto.startDate();
        this.endDate = academicEducationDto.endDate();
    }
}
