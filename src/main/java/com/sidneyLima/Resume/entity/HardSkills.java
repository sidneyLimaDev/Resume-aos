package com.sidneyLima.Resume.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.sidneyLima.Resume.dto.HardSkillsDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "hard_skills")
@NoArgsConstructor
@AllArgsConstructor
public class HardSkills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    @JsonBackReference
    private Resume resume;

    public HardSkills(HardSkillsDto hardSkillsDto) {
        this.name = hardSkillsDto.name();
    }
}
