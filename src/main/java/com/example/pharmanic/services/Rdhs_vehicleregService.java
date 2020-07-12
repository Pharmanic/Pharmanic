package com.example.pharmanic.services;


import com.example.pharmanic.model.Rdhs_vehiclereg;
import com.example.pharmanic.repositories.Rdhs_vehicleregRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Rdhs_vehicleregService {
    @Autowired
    Rdhs_vehicleregRepository Rdhs_vehicleregRepository;

    //getRdhs_vehicleregList
    public List<Rdhs_vehiclereg> getRdhs_vehicleregList() {
        List<Rdhs_vehiclereg> Rdhs_vehicleregList = Rdhs_vehicleregRepository.findAll();
        return Rdhs_vehicleregList;
    }

    //getMinistryVehicleDetails
    public Rdhs_vehiclereg getRdhs_vehicleregDetails(String vehicle_no) {
        if (vehicle_no != null) {
            if (Rdhs_vehicleregRepository.existsById(vehicle_no)) {
                return Rdhs_vehicleregRepository.findByVehicle_no(vehicle_no);
            }
        }
        return new Rdhs_vehiclereg();
    }

    //addDrugsToMinistryCurrentStore
    public Integer addRdhs_vehiclereg(Rdhs_vehiclereg Rdhs_vehiclereg) {
        Rdhs_vehicleregRepository.save(Rdhs_vehiclereg);
        return 1;
    }


}
