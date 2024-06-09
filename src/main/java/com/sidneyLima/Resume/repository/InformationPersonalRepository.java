package com.sidneyLima.Resume.repository;


import com.sidneyLima.Resume.entity.InformationPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformationPersonalRepository extends JpaRepository<InformationPersonal, Long> {
    List<InformationPersonal> findAllByPosition(String position);
}
