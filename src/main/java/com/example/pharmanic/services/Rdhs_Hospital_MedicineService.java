package com.example.pharmanic.services;

import com.example.pharmanic.model.Hospital_By_Rdhs;
import com.example.pharmanic.model.Medicine;
import com.example.pharmanic.model.Rdhs_Hospital_Current_Stock;
import com.example.pharmanic.repositories.Rdhs_Hospital_MedicineRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/api")

public class Rdhs_Hospital_MedicineService {
    private Rdhs_Hospital_MedicineRepository rdhs_hospital_medicineRepository;


    @GetMapping("/allrdmedicine")
    Collection<Medicine> allMedicine() {
        return rdhs_hospital_medicineRepository.findAll();
    }

    @RequestMapping(value = "/medicinerdhs", method = RequestMethod.GET)
    Medicine getMedicine(@PathVariable("sr_no") String sr_no) {
        return rdhs_hospital_medicineRepository.findBySr_no(sr_no);

    }
}
