package com.example.pharmanic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Direct_HospitalController {
    private final Direct_HospitalRepository repository;

    public Direct_HospitalController(Direct_HospitalRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/directhospitals")
    List<Direct_Hospital> all(){
        return repository.findAll();
    }

    @PostMapping("/directhospital")
    Direct_Hospital newHospital(@RequestBody Direct_Hospital newDirectHospital){
        return repository.save(newDirectHospital);
    }
}
