package com.example.pharmanic.web;

import com.example.pharmanic.model.Rdhs_Hospital_Current_Stock;
import com.example.pharmanic.model.Rdhs_Hospital_Return_Drug;

import com.example.pharmanic.repositories.Rdhs_Hospital_Return_DrugRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

public class Rdhs_Hospital_Return_DrugController {
    private Rdhs_Hospital_Return_DrugRepository rdhs_hospital_return_drug;

    public Rdhs_Hospital_Return_DrugController(Rdhs_Hospital_Return_DrugRepository rdhs_hospital_return_drug) {
       super();
        this.rdhs_hospital_return_drug = rdhs_hospital_return_drug;
    }

    @GetMapping("/rhreturndrug")
    Collection<Rdhs_Hospital_Return_Drug> drugStore() {

        return rdhs_hospital_return_drug.findAll();
    }

}
