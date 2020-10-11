package com.example.pharmanic.services;

import com.example.pharmanic.model.Rrdhs_driverreg;
import com.example.pharmanic.repositories.Rrdhs_driverregRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Rrdhs_driverregService {
    @Autowired
    Rrdhs_driverregRepository Rrdhs_driverregRepository;


    public List<Rrdhs_driverreg> getRdhs_driverregList() {
        List<Rrdhs_driverreg> rrdhs_driverregList = Rrdhs_driverregRepository.findAll();
        return rrdhs_driverregList;
    }

    public Rrdhs_driverreg getRdhs_driverregDetails(String nic) {
        if (nic != null) {
            if (Rrdhs_driverregRepository.existsById(nic)) {
                return Rrdhs_driverregRepository.findByNic(nic);
            }
        }
        return new Rrdhs_driverreg();
    }


    public Integer addRdhs_driverreg(Rrdhs_driverreg Rrdhs_driverreg) {
        Rrdhs_driverregRepository.save(Rrdhs_driverreg);
        return 1;
    }
}
