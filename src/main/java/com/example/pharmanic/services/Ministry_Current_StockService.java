package com.example.pharmanic.services;

import com.example.pharmanic.model.Ministry_Current_Stock;
import com.example.pharmanic.repositories.Ministry_Current_StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ministry_Current_StockService {
    @Autowired
    Ministry_Current_StockRepository ministry_current_stockRepository;

    //getMinistryCurrentStock
    public List<Ministry_Current_Stock> getMinistryCurrentStockList(){
        List<Ministry_Current_Stock> ministry_current_stockList=ministry_current_stockRepository.findAll();
        return ministry_current_stockList;
    }

    //addDrugsToMinistryCurrentStore
    public Integer addDrugsToMinistryCurrentStock(Ministry_Current_Stock ministry_current_stock){
        ministry_current_stockRepository.save(ministry_current_stock);
        return 1;
    }


}
