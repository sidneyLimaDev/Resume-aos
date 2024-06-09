package com.sidneyLima.Resume.repository;


import com.sidneyLima.Resume.entity.HardSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardSkillsRepository extends JpaRepository<HardSkills, Long> {
}
