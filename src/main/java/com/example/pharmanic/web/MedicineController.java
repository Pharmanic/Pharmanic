package com.example.pharmanic.web;

import com.example.pharmanic.model.Medicine;
import com.example.pharmanic.repositories.MedicineRepository;
import com.example.pharmanic.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class MedicineController {

    @Autowired
    MedicineRepository medicineRepository;

    @Autowired
    MedicineService medicineService;

    @GetMapping("/medicines")
    public List<Medicine> medicines(){
        return medicineService.getMedicineList();
    }

    @GetMapping("/medicines/{sr_no}")
    public ResponseEntity<Medicine> getMdicine(@PathVariable("sr_no") String sr_no){
        Medicine medicine=(Medicine) medicineService.getMedicineDetails(sr_no);
        if(medicine.getSr_no() !=null){
            return ResponseEntity.ok(medicine);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/medicineCount")
    public Integer getMedicineCount(){
        return medicineService.getMedicineCount();
    }
}
