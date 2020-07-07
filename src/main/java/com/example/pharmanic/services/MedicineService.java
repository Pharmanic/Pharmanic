package com.example.pharmanic.services;

import com.example.pharmanic.model.Medicine;
import com.example.pharmanic.model.Ministry_Driver;
import com.example.pharmanic.repositories.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api")
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


    //addMedicine
    public Medicine addMedicine(Medicine regmed){
        return medicineRepository.save(regmed);

    }

}
