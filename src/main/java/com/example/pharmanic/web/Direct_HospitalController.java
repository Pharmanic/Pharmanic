package com.example.pharmanic.web;

import com.example.pharmanic.model.Direct_Hospital;
import com.example.pharmanic.repositories.Direct_HospitalRepository;
import com.example.pharmanic.services.Direct_HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class Direct_HospitalController {

    @Autowired
    Direct_HospitalRepository direct_hospitalRepository;

    @Autowired
    Direct_HospitalService direct_hospitalService;

    @GetMapping("/direct_hospitals")
    public List<Direct_Hospital> getDirectHospitalList(){
        return direct_hospitalService.getDirectHospitalList();
    }

    @GetMapping("/direct_hospitals/{reg_no}")
    public ResponseEntity<Direct_Hospital> getDirectHospital(@PathVariable("reg_no") String reg_no){
        Direct_Hospital direct_hospital =(Direct_Hospital) direct_hospitalService.getDirectHospitalDetails(reg_no);
        if(direct_hospital.getReg_no() != null){
            return ResponseEntity.ok(direct_hospital);
        }
        return ResponseEntity.noContent().build();
    }
}
