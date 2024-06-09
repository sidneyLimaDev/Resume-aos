package com.sidneyLima.Resume.repository;


import com.sidneyLima.Resume.entity.ExperienceProfessional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceProfessionalRepository extends JpaRepository<ExperienceProfessional, Long> {
}
