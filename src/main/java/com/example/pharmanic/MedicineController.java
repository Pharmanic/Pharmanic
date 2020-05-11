package com.example.pharmanic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicineController {
    private final MedicineRepository repository;

    public MedicineController(MedicineRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/medicines")
    List<Medicine> all(){
        return repository.findAll();
    }

    @PostMapping("/medicine")
    Medicine newMedicin(@RequestBody Medicine newMedicine){
        return repository.save(newMedicine);
    }
}
