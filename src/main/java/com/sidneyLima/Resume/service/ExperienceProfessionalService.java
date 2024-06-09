package com.sidneyLima.Resume.service;


import com.sidneyLima.Resume.entity.ExperienceProfessional;
import com.sidneyLima.Resume.exception.ObjectNotFound;
import com.sidneyLima.Resume.repository.ExperienceProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceProfessionalService {

    private final ExperienceProfessionalRepository experienceProfessionalRepository;

    @Autowired
    public ExperienceProfessionalService(ExperienceProfessionalRepository experienceProfessionalRepository) {
        this.experienceProfessionalRepository = experienceProfessionalRepository;
    }

    public ExperienceProfessional updateExperienceProfessional(Long id, ExperienceProfessional experienceProfessional) {
        var existingExperienceProfessional = experienceProfessionalRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Professional experience not found with id: " + id));

        var updatedExperienceProfessional = updateData(existingExperienceProfessional, experienceProfessional);

        return experienceProfessionalRepository.save(updatedExperienceProfessional);
    }

    public void deleteExperienceProfessional(Long id) {
        var experienceProfessional = experienceProfessionalRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Professional experience not found with id: " + id));
        experienceProfessionalRepository.delete(experienceProfessional);
    }

    public ExperienceProfessional getExperienceProfessionalById(Long id) {
        return experienceProfessionalRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Professional experience not found with id: " + id));
    }

    public List<ExperienceProfessional> getAllExperienceProfessionals() {
        var experienceProfessionals = experienceProfessionalRepository.findAll();

        if (experienceProfessionals.isEmpty()) {
            throw new ObjectNotFound("No professional experiences found");
        }

        return experienceProfessionals;
    }

    private ExperienceProfessional updateData(ExperienceProfessional existingExperienceProfessional, ExperienceProfessional newExperienceProfessional) {
        existingExperienceProfessional.setDescription(newExperienceProfessional.getDescription());

        return existingExperienceProfessional;
    }
}
