package com.example.pharmanic.services;

import com.example.pharmanic.model.Medicine;
import com.example.pharmanic.repositories.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {
    @Autowired
    MedicineRepository medicineRepository;

    //getEMedicineList
    public List<Medicine> getMedicineList(){
        List<Medicine> medicineList=medicineRepository.findAll();
        return medicineList;
    }

    //getMedicineDetails
    public Medicine getMedicineDetails(String sr_no){
        if (sr_no !=null){
            if (medicineRepository.existsById(sr_no)){
                return medicineRepository.findBySr_no(sr_no);
            }
        }
        return new Medicine();
    }


}
