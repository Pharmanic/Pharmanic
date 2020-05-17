package com.example.pharmanic.web;

import com.example.pharmanic.model.Exported_Stock;
import com.example.pharmanic.model.Ministry_Current_Stock;
import com.example.pharmanic.repositories.Exported_StockRepository;
import com.example.pharmanic.services.Exported_StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class Exported_StockController {

    @Autowired
    Exported_StockRepository exported_stockRepository;

    @Autowired
    Exported_StockService exported_stockService;

    @GetMapping("/exportedstocks")
    public List<Exported_Stock> getExportedStockList(){
        return exported_stockService.getExportedStockList();
    }

    @PostMapping("/exportedstock/add")
    public Integer addExportedStock(@RequestBody Exported_Stock exported_stock){
        return exported_stockService.addExportedStock(exported_stock);
    }
}
