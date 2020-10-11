package com.example.pharmanic.web;

import com.example.pharmanic.repositories.Rdhs_Current_StockRepository;
import com.example.pharmanic.services.Rdhs_Current_StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class Rdhs_Current_StockController {
    @Autowired
    Rdhs_Current_StockRepository rdhs_current_stockRepository;
    @Autowired
    Rdhs_Current_StockService rdhs_current_stockService;

    @PostMapping("/rdhscurrentstock/add")
    public Integer addMinistryCurrentStock(@RequestBody Long x){
        return rdhs_current_stockService.addDrugsToRdhs(x);
    }
}
