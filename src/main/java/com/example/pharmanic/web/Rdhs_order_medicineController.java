package com.example.pharmanic.web;


import com.example.pharmanic.model.Rdhs_order_medicine;
import com.example.pharmanic.model.Rdhs_vehiclereg;
import com.example.pharmanic.repositories.Rdhs_order_medicineRepository;
import com.example.pharmanic.repositories.Rdhs_vehicleregRepository;
import com.example.pharmanic.services.Rdhs_order_medicineService;
import com.example.pharmanic.services.Rdhs_vehicleregService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class Rdhs_order_medicineController {
    @Autowired
    com.example.pharmanic.repositories.Rdhs_order_medicineRepository Rdhs_order_medicineRepository;

    @Autowired
    com.example.pharmanic.services.Rdhs_order_medicineService Rdhs_order_medicineService;

    @GetMapping("/Rdhs_order_medicine")
    public List<Rdhs_order_medicine> getRdhs_order_medicineList(){
        return Rdhs_order_medicineService.getRdhs_order_medicineList();
    }

    @GetMapping("/Rdhs_order_medicine/{sr_no}")
    public ResponseEntity<Rdhs_order_medicine> getRdhs_order_medicine(@PathVariable("sr_no") String sr_no){
        Rdhs_order_medicine Rdhs_order_medicine=(Rdhs_order_medicine) Rdhs_order_medicineService.getRdhs_order_medicineDetails(sr_no);
        if(Rdhs_order_medicine.getsr_no() !=null){
            return ResponseEntity.ok(Rdhs_order_medicine);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/Rdhs_order_medicine/add")
    public Integer addRdhs_order_medicine(@RequestBody Rdhs_order_medicine Rdhs_order_medicine){
        return Rdhs_order_medicineService.addRdhs_order_medicine(Rdhs_order_medicine);
    }
}
