package com.sidneyLima.Resume.service;


import com.sidneyLima.Resume.entity.InformationPersonal;
import com.sidneyLima.Resume.exception.ObjectNotFound;
import com.sidneyLima.Resume.repository.InformationPersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationPersonalService {

    private final InformationPersonalRepository informationPersonalRepository;

    @Autowired
    public InformationPersonalService(InformationPersonalRepository informationPersonalRepository) {
        this.informationPersonalRepository = informationPersonalRepository;
    }

    public InformationPersonal updateInformationPersonal(Long id, InformationPersonal newInformationPersonal) {
        var oldInformationPersonal = informationPersonalRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Personal information not found with id: " + id));

        var informationPersonal = updateData(oldInformationPersonal, newInformationPersonal);
        return informationPersonalRepository.save(informationPersonal);
    }

    public void deleteInformationPersonal(Long id) {
        informationPersonalRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Personal information not found with id: " + id));

        informationPersonalRepository.deleteById(id);
    }

    public InformationPersonal getInformationPersonalById(Long id) {
        return informationPersonalRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Personal information not found with id: " + id));
    }

    public List<InformationPersonal> getAllInformationPersonal() {
        var informationPersonalList = informationPersonalRepository.findAll();
        if (informationPersonalList.isEmpty()) {
            throw new ObjectNotFound("No personal information found");
        }

        return informationPersonalList;
    }

    public List<InformationPersonal> findAllByPosition(String position) {
        var informationPersonalList = informationPersonalRepository.findAllByPosition(position);

        if (informationPersonalList.isEmpty()) {
            throw new ObjectNotFound("No personal information found with the position: " + position);
        }

        return informationPersonalList;
    }

    private InformationPersonal updateData(InformationPersonal oldInformationPersonal, InformationPersonal newInformationPersonal) {
        oldInformationPersonal.setFullName(newInformationPersonal.getFullName());
        oldInformationPersonal.setCity(newInformationPersonal.getCity());
        oldInformationPersonal.setState(newInformationPersonal.getState());
        oldInformationPersonal.setEmail(newInformationPersonal.getEmail());
        oldInformationPersonal.setCountry(newInformationPersonal.getCountry());
        oldInformationPersonal.setPosition(newInformationPersonal.getPosition());

        return oldInformationPersonal;
    }
}
