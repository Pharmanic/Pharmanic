package com.example.pharmanic.web;

import com.example.pharmanic.model.Supply_Order_To_Direct_Hospital;
import com.example.pharmanic.model.Supply_Order_To_Rdhs;
import com.example.pharmanic.repositories.Supply_Order_To_RdhsRepository;
import com.example.pharmanic.services.Supply_Order_Service;
import com.example.pharmanic.services.Supply_Order_To_RdhsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class Supply_Order_To_RdhsController {

    @Autowired
    Supply_Order_To_RdhsRepository supply_order_to_rdhsRepository;

    @Autowired
    Supply_Order_To_RdhsService supply_order_to_rdhsService;
    @Autowired
    Supply_Order_Service supplyOrderService;

    @PostMapping("/supplyordertordhs/add")
    public Integer addSupplyOrderTordhs(@RequestBody Supply_Order_To_Rdhs supply_order_to_rdhs){
        return supply_order_to_rdhsService.addSupplyOrderToRdhs(supply_order_to_rdhs);
    }

    @GetMapping("/getWeeklySupply")
    public Integer[] getWeeklySupply(){
        return supplyOrderService.getWeeklySupplyDetails();
    }

    @GetMapping("/getWeeklyDemand")
    public Integer[] getWeeklyDemand(){
        return supplyOrderService.getWeeklyDemandDetails();
    }

    @GetMapping("/getWeeklySupplyDates")
    public Date[] getWeeklySupplyDates(){
        return supplyOrderService.getWeeklySupplyDays();
    }


}
