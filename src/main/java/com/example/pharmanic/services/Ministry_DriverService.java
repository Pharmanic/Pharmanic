package com.example.pharmanic.services;

import com.example.pharmanic.model.Medicine;
import com.example.pharmanic.model.Ministry_Current_Stock;
import com.example.pharmanic.model.Ministry_Driver;
import com.example.pharmanic.model.Rdhs;
import com.example.pharmanic.repositories.Ministry_DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ministry_DriverService {

    @Autowired
    Ministry_DriverRepository ministry_driverRepository;

    //getMinistryDriverList
    public List<Ministry_Driver> getMinistryDriverList(){
        List<Ministry_Driver> ministry_driverList=ministry_driverRepository.findAll();
        return ministry_driverList;
    }

    //getMinistryDriverDetails
    public Ministry_Driver getMinistryDriverDetails(String nic){
        if (nic !=null){
            if (ministry_driverRepository.existsById(nic)){
                return ministry_driverRepository.findByNic(nic);
            }
        }
        return new Ministry_Driver();
    }

    //addDrivers
    public Ministry_Driver addDriver(Ministry_Driver ministry_driver){
       return ministry_driverRepository.save(ministry_driver);

    }


}
