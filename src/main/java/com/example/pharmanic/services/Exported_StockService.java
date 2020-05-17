package com.example.pharmanic.services;

import com.example.pharmanic.model.Exported_Stock;
import com.example.pharmanic.model.Ministry_Current_Stock;
import com.example.pharmanic.repositories.Exported_StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Exported_StockService {

    @Autowired
    Exported_StockRepository exported_stockRepository;

    //getExportedStock
    public List<Exported_Stock> getExportedStockList(){
        List<Exported_Stock> exported_stockList=exported_stockRepository.findAll();
        return exported_stockList;
    }

    //addDrugsToMinistryCurrentStore
    public Integer addExportedStock(Exported_Stock exported_stock){
        exported_stockRepository.save(exported_stock);
        return 1;
    }
}
