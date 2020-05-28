package com.example.pharmanic.services;

import com.example.pharmanic.model.Direct_Hospital_Return_Drug;
import com.example.pharmanic.repositories.Direct_Hospital_Return_DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Direct_Hospital_Return_DrugService {
    @Autowired
    Direct_Hospital_Return_DrugRepository direct_hospital_return_drugRepository;

    //getDirectHospitalReturnDrugs
    public List<Direct_Hospital_Return_Drug> getDirectHospitalReturnDrugList(){
        List<Direct_Hospital_Return_Drug> direct_hospital_return_drugList=direct_hospital_return_drugRepository.findAll();
        return direct_hospital_return_drugList;
    }

    //addDrugsToDirectHospitalReturnDrug
    public Integer addDrugsToDirectHospitalReturnDrug(Direct_Hospital_Return_Drug direct_hospital_return_drug){
        direct_hospital_return_drugRepository.save(direct_hospital_return_drug);
        return 1;
    }
}
