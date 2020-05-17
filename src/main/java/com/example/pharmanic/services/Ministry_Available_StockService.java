package com.example.pharmanic.services;

import com.example.pharmanic.model.Ministry_Available_Stock;
import com.example.pharmanic.model.Ministry_Current_Stock;
import com.example.pharmanic.repositories.Ministry_Available_StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ministry_Available_StockService {

    @Autowired
    Ministry_Available_StockRepository ministry_available_stockRepository;

    //getMinistryAvailableStock
    public List<Ministry_Available_Stock> getMinistryAvailableStockList(){
        List<Ministry_Available_Stock> ministry_available_stockList=ministry_available_stockRepository.findAll();
        return ministry_available_stockList;
    }

    //addDrugsToMinistryAvailableStore
    public Integer addDrugsToMinistryAvailableStock(Ministry_Available_Stock ministry_available_stock){
        ministry_available_stockRepository.save(ministry_available_stock);
        return 1;
    }
}
