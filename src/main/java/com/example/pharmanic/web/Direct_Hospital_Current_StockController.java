package com.example.pharmanic.web;

import com.example.pharmanic.model.Direct_Hospital_Current_Stock;
import com.example.pharmanic.repositories.Direct_Hospital_Current_StockRepository;
import com.example.pharmanic.services.Direct_Hospital_Current_StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class Direct_Hospital_Current_StockController {

    @Autowired
    Direct_Hospital_Current_StockRepository direct_hospital_current_stockRepository;

    @Autowired
    Direct_Hospital_Current_StockService direct_hospital_current_stockService;

    @GetMapping("/directhospitalcurrentstocks")
    public List<Direct_Hospital_Current_Stock> getDirectHospitalCurrentStockList(){
        return direct_hospital_current_stockService.getDirectHospitalCurrentStockList();
    }

    @PostMapping("/directhospitalcurrentstock/add")
    public Integer addDirectHospitalCurrentStock(@RequestBody Direct_Hospital_Current_Stock direct_hospital_current_stock){
        return direct_hospital_current_stockService.addDrugsToDirectHospitalCurrentStock(direct_hospital_current_stock);
    }
}
