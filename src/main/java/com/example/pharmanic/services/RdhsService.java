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
                return rdhsRepository.findById(reg_no).get();
            }
        }
        return new Rdhs();
    }
    public Rdhs addRdhs(Rdhs newRdhs){
        return rdhsRepository.save(newRdhs);
    }

    public Rdhs updateRdhs(Rdhs rdhs){
        if(isExixts(rdhs))
             return rdhsRepository.save(rdhs);
        return null;
    }

    public boolean isExixts(Rdhs rdhs){
        if(rdhsRepository.findById(rdhs.getReg_no()).get()!=null)
            return true;
        return false;
    }

    public Integer deleteRdhs(String reg_no){
        if(rdhsRepository.findById(reg_no).get()!=null) {
            rdhsRepository.deleteById(reg_no);
            return 1;
    }
        return 0;
    }
}
