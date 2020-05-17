package com.example.pharmanic.web;

import com.example.pharmanic.model.Ministry_Available_Stock;
import com.example.pharmanic.model.Ministry_Current_Stock;
import com.example.pharmanic.repositories.Ministry_Available_StockRepository;
import com.example.pharmanic.services.Ministry_Available_StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class Ministry_Available_StockContoller {

    @Autowired
    Ministry_Available_StockRepository ministry_available_stockRepository;

    @Autowired
    Ministry_Available_StockService ministry_available_stockService;

    @GetMapping("/ministryavailablestocks")
    public List<Ministry_Available_Stock> getMinistryAvailableStockList(){
        return ministry_available_stockService.getMinistryAvailableStockList();
    }

    @PostMapping("/ministryavailablestock/add")
    public Integer addMinistryAvailableStock(@RequestBody Ministry_Available_Stock ministry_available_stock){
        return ministry_available_stockService.addDrugsToMinistryAvailableStock(ministry_available_stock);
    }
}
