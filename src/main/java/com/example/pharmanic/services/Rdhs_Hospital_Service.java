package com.example.pharmanic.services;

import com.example.pharmanic.model.Hospital_By_Rdhs;
import com.example.pharmanic.model.Medicine;
import com.example.pharmanic.model.Rdhs_Hospital_Current_Stock;
import com.example.pharmanic.repositories.Rdhs_HospitalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Rdhs_Hospital_Service {
   private Rdhs_HospitalRepository rdhs_hospitalRepository;



    @GetMapping("/getallrdhos")
    Collection<Hospital_By_Rdhs> allMedicine() {
        return rdhs_hospitalRepository.findAll();
    }


    @RequestMapping(value = "/rdhospital", method = RequestMethod.GET)
    Hospital_By_Rdhs getHospitalBatch(@PathVariable("reg_no") String reg_no) {
        return rdhs_hospitalRepository.findByreg_no(reg_no);

    }
}
