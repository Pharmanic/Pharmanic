package com.example.pharmanic.web;

import com.example.pharmanic.model.Direct_Hospital_Return_Drug;
import com.example.pharmanic.repositories.Direct_Hospital_Return_DrugRepository;
import com.example.pharmanic.services.Direct_Hospital_Return_DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class Direct_Hospital_Return_DrugController {

    @Autowired
    Direct_Hospital_Return_DrugRepository direct_hospital_return_drugRepository;

    @Autowired
    Direct_Hospital_Return_DrugService direct_hospital_return_drugService;

    @GetMapping("/directhospitalreturndrug")
    public List<Direct_Hospital_Return_Drug> getDirectHospitalReturnDrugList(){
        return direct_hospital_return_drugService.getDirectHospitalReturnDrugList();
    }

    @PostMapping("/directhospitalreturndrug/add")
    public Integer addDirectHospitalReturnDrug(@RequestBody Direct_Hospital_Return_Drug direct_hospital_return_drug){
        return direct_hospital_return_drugService.addDrugsToDirectHospitalReturnDrug(direct_hospital_return_drug);
    }
}
