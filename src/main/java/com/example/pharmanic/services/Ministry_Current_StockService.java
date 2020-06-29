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
    //getMinistryCurrentStockNearestexpiringDrugs
    public List<Ministry_Current_Stock> getNearestExpiringMedicineList(){
        List<Ministry_Current_Stock> nearest_expiring_list=ministry_current_stockRepository.nearestExpiringList();
        return nearest_expiring_list;
    }

    //addDrugsToMinistryCurrentStore
    public Integer addDrugsToMinistryCurrentStock(Ministry_Current_Stock ministry_current_stock){
        ministry_current_stockRepository.save(ministry_current_stock);
        try{
            ministry_current_stockRepository.updateAvailableStock(ministry_current_stock.getBatch_id());
        }catch (NullPointerException ex){

        }

        return 1;
    }

    public Ministry_Current_Stock updateMinistryCurrentStock(Ministry_Current_Stock ministry_current_stock) {
        if (ministry_current_stockRepository.existsById(ministry_current_stock.getBatch_id())) {
            return ministry_current_stockRepository.save(ministry_current_stock);
        }

        return new Ministry_Current_Stock();
    }

    public String deleteministryCurrentStock(Long batch_id) {
        if (batch_id != null) {
            if (ministry_current_stockRepository.existsById(batch_id)) {
                ministry_current_stockRepository.deleteById(batch_id);
                return "success";
            }
        }
        return "error";
    }


}
