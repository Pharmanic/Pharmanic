package com.example.pharmanic.web;

import com.example.pharmanic.model.Ministry_Vehicle;
import com.example.pharmanic.model.Supply_Order_To_Direct_Hospital;
import com.example.pharmanic.repositories.Supply_Order_To_Direct_HospitalRepository;
import com.example.pharmanic.services.Supply_Order_To_Direct_HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class Supply_Order_To_Direct_HospitalController {

    @Autowired
    Supply_Order_To_Direct_HospitalRepository supply_order_to_direct_hospitalRepository;

    @Autowired
    Supply_Order_To_Direct_HospitalService supply_order_to_direct_hospitalService;
    
    @PostMapping("/supplyordertodh/add")
    public Integer addSupplyOrderToDH(@RequestBody Supply_Order_To_Direct_Hospital supply_order_to_direct_hospital){
        return supply_order_to_direct_hospitalService.addSupplyOrderToDirectHospital(supply_order_to_direct_hospital);
    }

    @PostMapping("/closeorder/{id}")
    public Integer closeorder(@PathVariable("id") Long id){
        return supply_order_to_direct_hospitalService.closeorder(id);
    }
}
