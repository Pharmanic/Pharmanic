package com.example.pharmanic.web;

import com.example.pharmanic.model.Rdhs;
import com.example.pharmanic.model.Rdhs_Damage_Stock;
import com.example.pharmanic.repositories.Rdhs_Damage_StockRepository;
import com.example.pharmanic.services.Rdhs_Damage_StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",maxAge = 3600)
public class Rdhs_Damage_StockController {
    @Autowired
    Rdhs_Damage_StockRepository rdhs_damage_stockRepository;
    @Autowired
    Rdhs_Damage_StockService rdhs_damage_stockService;

    @GetMapping("/rdhsdamagestocks")
    public List<Rdhs_Damage_Stock> getRdhsDamageStockList(){
        return rdhs_damage_stockService.getRdhsDamageDrugStockList();
    }

    @PostMapping("/rdhsdamagestock/add")
    public Integer addRdhsDamageStock(@RequestBody Rdhs_Damage_Stock rdhs_damage_stock){
        return rdhs_damage_stockService.addDrugsToRdhsDamageStock(rdhs_damage_stock);
    }
}
