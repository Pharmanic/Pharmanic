package com.example.pharmanic.services;

import com.example.pharmanic.model.Rdhs_order_medicine;
import com.example.pharmanic.repositories.Rdhs_order_medicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Rdhs_order_medicineService {
    @Autowired
    com.example.pharmanic.repositories.Rdhs_order_medicineRepository Rdhs_order_medicineRepository;


    public List<Rdhs_order_medicine> getRdhs_order_medicineList() {
        List<Rdhs_order_medicine> Rdhs_order_medicineList = Rdhs_order_medicineRepository.findAll();
        return Rdhs_order_medicineList;
    }

    public Rdhs_order_medicine getRdhs_order_medicineDetails(String sr_no) {
        if (sr_no != null) {
            if (Rdhs_order_medicineRepository.existsById(sr_no)) {
                return Rdhs_order_medicineRepository.findBysr_no(sr_no);
            }
        }
        return new Rdhs_order_medicine();
    }


    public Integer addRdhs_order_medicine(Rdhs_order_medicine Rdhs_order_medicine) {
        Rdhs_order_medicineRepository.save(Rdhs_order_medicine);
        return 1;
    }
}
