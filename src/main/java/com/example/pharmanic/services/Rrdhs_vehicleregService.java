package com.example.pharmanic.services;


import com.example.pharmanic.model.Rrdhs_vehiclereg;
import com.example.pharmanic.repositories.Rrdhs_vehicleregRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Rrdhs_vehicleregService {
    @Autowired
    Rrdhs_vehicleregRepository Rrdhs_vehicleregRepository;

    //getRdhs_vehicleregList
    public List<Rrdhs_vehiclereg> getRdhs_vehicleregList() {
        List<Rrdhs_vehiclereg> rrdhs_vehicleregList = Rrdhs_vehicleregRepository.findAll();
        return rrdhs_vehicleregList;
    }

    //getMinistryVehicleDetails
    public Rrdhs_vehiclereg getRdhs_vehicleregDetails(String vehicle_no) {
        if (vehicle_no != null) {
            if (Rrdhs_vehicleregRepository.existsById(vehicle_no)) {
                return Rrdhs_vehicleregRepository.findByVehicle_no(vehicle_no);
            }
        }
        return new Rrdhs_vehiclereg();
    }

    //addDrugsToMinistryCurrentStore
    public Integer addRdhs_vehiclereg(Rrdhs_vehiclereg Rrdhs_vehiclereg) {
        Rrdhs_vehicleregRepository.save(Rrdhs_vehiclereg);
        return 1;
    }


}
