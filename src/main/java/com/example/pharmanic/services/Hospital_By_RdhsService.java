package com.example.pharmanic.services;

import com.example.pharmanic.model.Direct_Hospital;
import com.example.pharmanic.model.Hospital_By_Rdhs;
import com.example.pharmanic.repositories.Hospital_By_RdhsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Hospital_By_RdhsService {

    @Autowired
    Hospital_By_RdhsRepository hospitalByRdhsRepository;

    //getDirectHospitalList
    public List<Hospital_By_Rdhs> getHospitalsByRdhsList(){
        List<Hospital_By_Rdhs> hospitalByRdhsList=hospitalByRdhsRepository.findAll();
        return hospitalByRdhsList;
    }

    //getDirectHospitalDetails
    public Hospital_By_Rdhs getHospitalByRdhsDetails(String reg_no){
        if(reg_no != null){
            if (hospitalByRdhsRepository.existsById(reg_no)){
                return hospitalByRdhsRepository.findByReg_no(reg_no);
            }
        }
        return new Hospital_By_Rdhs();
    }

    //addDirectHospital
    public Integer addHospitalByRdhs(Hospital_By_Rdhs hospital_By_Rdhs){
       Hospital_By_Rdhs hospital_by_rdhs= hospitalByRdhsRepository.save(hospital_By_Rdhs);
       if(hospital_By_Rdhs!=null)
         return 1;
       return 0;
    }

    public Integer deleteHospitalByRdhs(String reg_no) {
        if (reg_no != null) {
            if (hospitalByRdhsRepository.existsById(reg_no)) {
                hospitalByRdhsRepository.deleteById(reg_no);
                return 1;
            }
        }
        return 0;
    }

    public Hospital_By_Rdhs updateHospitalByRdhs(Hospital_By_Rdhs hospital_by_rdhs){
        if(hospital_by_rdhs.getReg_no()!=null) {
            if (isExists(hospital_by_rdhs))
                return hospitalByRdhsRepository.save(hospital_by_rdhs);
            return null;
        }
        return null;
    }

    public boolean isExists(Hospital_By_Rdhs hospital_by_rdhs){
        if(hospitalByRdhsRepository.findById(hospital_by_rdhs.getReg_no()).get()!=null)
            return true;
        return false;
    }
    public Integer getRDHSHospitalCount() {
                return hospitalByRdhsRepository.gerRDHSHospitalCount();

    }



}
