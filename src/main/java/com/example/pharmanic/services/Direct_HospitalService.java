package com.example.pharmanic.services;

import com.example.pharmanic.model.Direct_Hospital;
import com.example.pharmanic.model.Ministry_Current_Stock;
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

    //addDirectHospital
    public Direct_Hospital addDirectHospital(Direct_Hospital direct_hospital){
       return  direct_hospitalRepository.save(direct_hospital);
    }

    public Direct_Hospital updateDirectHospital(Direct_Hospital direct_hospital){
        if(isExixts(direct_hospital))
            return direct_hospitalRepository.save(direct_hospital);
        return null;
    }

    public boolean isExixts(Direct_Hospital rdhs){
        if(direct_hospitalRepository.findById(rdhs.getReg_no()).get()!=null)
            return true;
        return false;
    }

    public Integer deleteDirectHospital(String reg_no){
        if(direct_hospitalRepository.findById(reg_no).get()!=null) {
            direct_hospitalRepository.deleteById(reg_no);
            return 1;
        }
        return 0;
    }




}
