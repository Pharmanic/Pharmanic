package com.example.pharmanic.web;

import com.example.pharmanic.model.Supply_Order_To_Direct_Hospital;
import com.example.pharmanic.model.Supply_Order_To_Rdhs;
import com.example.pharmanic.repositories.Supply_Order_Detail_To_RdhsRepository;
import com.example.pharmanic.repositories.Supply_Order_To_Direct_HospitalRepository;
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
    Supply_Order_Detail_To_RdhsRepository supply_Order_Detail_To_RdhsRepository;

//    @Autowired
//     supply_order_to_rdhsRepository;

    @Autowired
    Supply_Order_To_RdhsService supply_order_to_rdhsService;
    @Autowired
    Supply_Order_Service supplyOrderService;

    @PostMapping("/supplyordertordhs/add")
    public Integer addSupplyOrderTordhs(@RequestBody Supply_Order_To_Rdhs supply_order_to_rdhs){
        return supply_order_to_rdhsService.addSupplyOrderToRdhs(supply_order_to_rdhs);
    }
    //    @PostMapping("/closeorderrdhs/{id}")
//    public Integer closeorderrdhs(@PathVariable("id") Long id){
//        return supply_order_to_rdhsService.closeorder(id);
//    }

    @PostMapping("/closeorderrdhs/{id}")
    public Integer closeorder(@PathVariable("id") Long id){
        System.out.println("incontroller");
        //   return supply_order_to_direct_hospitalRepository.suppliedcount(id);
        return supply_order_to_rdhsService.closeorder(id);
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

    @GetMapping("/getRDHSCurrentYearSupply")
        public Integer getRDHSCurrentYearSupply(){
        System.out.println("RDHS Supply"+supplyOrderService.getRDHSYearlySupplyCount());
        return supplyOrderService.getRDHSYearlySupplyCount();
    }

    @GetMapping("/getDirectCurrentYearSupply")
    public Integer getDirectCurrentYearSupply(){
        System.out.println("Dir Cur"+supplyOrderService.getDirectYearlySupplyCount());
        return supplyOrderService.getDirectYearlySupplyCount();
    }

    @GetMapping("/getRDHSCurrentYearDemand")
    public Integer getRDHSCurrentYearDemand(){
        System.out.println("-----RDHS Cur"+supplyOrderService.getRDHSYearsDemandCount());

        return supplyOrderService.getRDHSYearsDemandCount();
    }

    @GetMapping("/getDirectCurrentYearDemand")
    public Integer getDirectCurrentYearDemand(){
        System.out.println("-----Dir Cur"+supplyOrderService.getDirectYearsDemandCount());
        return supplyOrderService.getDirectYearsDemandCount();
    }

    @GetMapping("/getRDHSHospitalCurrentYearSupply")
    public Integer getRDHSHospitalCurrentYearSupply(){
        System.out.println(">>>>>>>>>>>"+supply_Order_Detail_To_RdhsRepository.getSupply());
        return supply_Order_Detail_To_RdhsRepository.getSupply();
    }
    @GetMapping("/getRDHSHospitalCurrentYearDemand")
    public Integer getRDHSHospitalCurrentYearDemand(){
        System.out.println("<<<<<<<<<<<<<");
        System.out.println(">>>>>>>>>>.."+supply_Order_Detail_To_RdhsRepository.getDemand());
        return supply_Order_Detail_To_RdhsRepository.getDemand();
    }

    @GetMapping("/getCurrentStockOfAll")
    public Integer[] getCurrentStockOfAll(){
        System.out.println("getCurrentStockOfAll");
        return supplyOrderService.totalSupplies();
    }

}
