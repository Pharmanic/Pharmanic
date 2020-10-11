package com.example.pharmanic.web;

import com.example.pharmanic.model.Supply_Order_To_Direct_Hospital;
import com.example.pharmanic.model.Supply_Order_To_Rdhs;
import com.example.pharmanic.repositories.Supply_Order_To_RdhsRepository;
import com.example.pharmanic.services.Supply_Order_To_RdhsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class Supply_Order_To_RdhsController {

    @Autowired
    Supply_Order_To_RdhsRepository supply_order_to_rdhsRepository;

    @Autowired
    Supply_Order_To_RdhsService supply_order_to_rdhsService;

    @PostMapping("/supplyordertohos/add")
    public Integer addSupplyOrderTordhs(@RequestBody Supply_Order_To_Rdhs supply_order_to_rdhs){
        return supply_order_to_rdhsService.addSupplyOrderToRdhs(supply_order_to_rdhs);
    }


}
