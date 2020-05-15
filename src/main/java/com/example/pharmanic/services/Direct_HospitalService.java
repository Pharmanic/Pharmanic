package com.example.pharmanic.services;

import com.example.pharmanic.model.Direct_Hospital;
import com.example.pharmanic.repositories.Direct_HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Direct_HospitalService {

    @Autowired
    Direct_HospitalRepository direct_hospitalRepository;

    //getDirectHospitalList
    public List<Direct_Hospital> getDirectHospitalList(){
        List<Direct_Hospital> direct_hospitalList=direct_hospitalRepository.findAll();
        return direct_hospitalList;
    }

    //getDirectHospitalDetails
    public Direct_Hospital getDirectHospitalDetails(String reg_no){
        if(reg_no != null){
            if (direct_hospitalRepository.existsById(reg_no)){
                return direct_hospitalRepository.findByReg_no(reg_no);
            }
        }
        return new Direct_Hospital();
    }

}
