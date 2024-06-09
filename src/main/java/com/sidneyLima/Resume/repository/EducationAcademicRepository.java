package com.sidneyLima.Resume.repository;


import com.sidneyLima.Resume.entity.EducationAcademic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationAcademicRepository extends JpaRepository<EducationAcademic, Long> {
}
