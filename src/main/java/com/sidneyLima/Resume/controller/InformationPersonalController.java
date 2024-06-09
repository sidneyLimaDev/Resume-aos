package com.sidneyLima.Resume.controller;


import com.sidneyLima.Resume.entity.InformationPersonal;
import com.sidneyLima.Resume.service.InformationPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/information-personal")
public class InformationPersonalController {

    private final InformationPersonalService informationPersonalService;

    @Autowired
    public InformationPersonalController(InformationPersonalService informationPersonalService) {
        this.informationPersonalService = informationPersonalService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<InformationPersonal> updateInformationPersonal(@PathVariable Long id, @RequestBody InformationPersonal informationPersonal) {
        InformationPersonal updatedInformationPersonal = informationPersonalService.updateInformationPersonal(id, informationPersonal);
        return ResponseEntity.ok(updatedInformationPersonal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInformationPersonal(@PathVariable Long id) {
        informationPersonalService.deleteInformationPersonal(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InformationPersonal> getInformationPersonalById(@PathVariable Long id) {
        InformationPersonal informationPersonal = informationPersonalService.getInformationPersonalById(id);
        return ResponseEntity.ok(informationPersonal);
    }

    @GetMapping("/")
    public ResponseEntity<List<InformationPersonal>> getAllInformationPersonal() {
        List<InformationPersonal> informationPersonalList = informationPersonalService.getAllInformationPersonal();
        return ResponseEntity.ok(informationPersonalList);
    }

    @GetMapping("/position/{position}")
    public ResponseEntity<List<InformationPersonal>> findAllByPosition(@PathVariable String position) {
        List<InformationPersonal> informationPersonalList = informationPersonalService.findAllByPosition(position);
        return ResponseEntity.ok(informationPersonalList);
    }
}
