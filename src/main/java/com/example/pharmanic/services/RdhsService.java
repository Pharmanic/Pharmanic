package com.example.pharmanic.services;

import com.example.pharmanic.model.Ministry_Vehicle;
import com.example.pharmanic.model.Rdhs;
import com.example.pharmanic.repositories.RdhsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RdhsService {

    @Autowired
    RdhsRepository rdhsRepository;

    //getRdhsList
    public List<Rdhs> getRdhsList(){
        List<Rdhs> rdhsList=rdhsRepository.findAll();
        return rdhsList;
    }

    //getRdhsDetails
    public Rdhs getRdhsDetails(String reg_no){
        if (reg_no !=null){
            if (rdhsRepository.existsById(reg_no)){
                return rdhsRepository.findByReg_no(reg_no);
            }
        }
        return new Rdhs();
    }
}
