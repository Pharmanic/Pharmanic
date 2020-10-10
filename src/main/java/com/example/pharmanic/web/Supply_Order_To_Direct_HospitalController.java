package com.example.pharmanic.web;

import com.example.pharmanic.model.Direct_Hospital_Request_Order;
import com.example.pharmanic.model.Ministry_Vehicle;
import com.example.pharmanic.model.Supply_Order_To_Direct_Hospital;
import com.example.pharmanic.repositories.Supply_Order_To_Direct_HospitalRepository;
import com.example.pharmanic.services.Supply_Order_To_Direct_HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class Supply_Order_To_Direct_HospitalController {

    @Autowired
    Supply_Order_To_Direct_HospitalRepository supply_order_to_direct_hospitalRepository;

    @Autowired
    Supply_Order_To_Direct_HospitalService supply_order_to_direct_hospitalService;


    @GetMapping("/supplyoorderstodhlist")
    public List<Supply_Order_To_Direct_Hospital> supplyorderlist(){
        return supply_order_to_direct_hospitalService.getSupplyOrdersToDirectHospitals();
    }

    @PostMapping("/supplyordertodh/add")
    public Integer addSupplyOrderToDH(@RequestBody Supply_Order_To_Direct_Hospital supply_order_to_direct_hospital){
        return supply_order_to_direct_hospitalService.addSupplyOrderToDirectHospital(supply_order_to_direct_hospital);
    }

    @PostMapping("/closeorder/{id}")
    public Integer closeorder(@PathVariable("id") Long id){
        System.out.println("incontroller");
     //   return supply_order_to_direct_hospitalRepository.suppliedcount(id);
        return supply_order_to_direct_hospitalService.closeorder(id);
    }
}
