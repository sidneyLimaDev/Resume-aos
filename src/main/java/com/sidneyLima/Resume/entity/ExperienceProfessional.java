package com.sidneyLima.Resume.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sidneyLima.Resume.dto.ExperienceProfessionalDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "professional_experiences")
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceProfessional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    @JsonBackReference
    private Resume resume;

    public ExperienceProfessional(ExperienceProfessionalDto ExperienceprofessionalDto) {
        this.description = ExperienceprofessionalDto.description();
    }
}
