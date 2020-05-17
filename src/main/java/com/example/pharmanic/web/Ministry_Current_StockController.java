package com.example.pharmanic.web;

import com.example.pharmanic.model.Ministry_Current_Stock;
import com.example.pharmanic.repositories.Ministry_Current_StockRepository;
import com.example.pharmanic.services.Ministry_Current_StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class Ministry_Current_StockController {

    @Autowired
    Ministry_Current_StockRepository ministry_current_stockRepository;

    @Autowired
    Ministry_Current_StockService ministry_current_stockService;

    @GetMapping("/ministrycurrentstocks")
    public List<Ministry_Current_Stock> getMinistryCurrentStockList(){
        return ministry_current_stockService.getMinistryCurrentStockList();
    }

    @PostMapping("/ministrycurrentstock/add")
    public Integer addMinistryCurrentStock(@RequestBody Ministry_Current_Stock ministry_current_stock){
        return ministry_current_stockService.addDrugsToMinistryCurrentStock(ministry_current_stock);
    }
}
