package com.example.pharmanic.services;

import com.example.pharmanic.model.Rdhs_driverreg;
import com.example.pharmanic.repositories.Rdhs_driverregRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Rdhs_driverregService {
    @Autowired
    Rdhs_driverregRepository Rdhs_driverregRepository;


    public List<Rdhs_driverreg> getRdhs_driverregList() {
        List<Rdhs_driverreg> Rdhs_driverregList = Rdhs_driverregRepository.findAll();
        return Rdhs_driverregList;
    }

    public Rdhs_driverreg getRdhs_driverregDetails(String nic) {
        if (nic != null) {
            if (Rdhs_driverregRepository.existsById(nic)) {
                return Rdhs_driverregRepository.findByNic(nic);
            }
        }
        return new Rdhs_driverreg();
    }


    public Integer addRdhs_driverreg(Rdhs_driverreg Rdhs_driverreg) {
        Rdhs_driverregRepository.save(Rdhs_driverreg);
        return 1;
    }
}
