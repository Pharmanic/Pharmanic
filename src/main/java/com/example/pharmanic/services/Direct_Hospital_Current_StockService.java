package com.example.pharmanic.services;

import com.example.pharmanic.model.Direct_Hospital_Current_Stock;
import com.example.pharmanic.repositories.Direct_Hospital_Current_StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Direct_Hospital_Current_StockService {
    @Autowired
    Direct_Hospital_Current_StockRepository direct_hospital_current_stockRepository;

    //getDirectHospitalCurrentStock
    public List<Direct_Hospital_Current_Stock> getDirectHospitalCurrentStockList(){
        List<Direct_Hospital_Current_Stock> direct_hospital_current_stockList=direct_hospital_current_stockRepository.findAll();
        return direct_hospital_current_stockList;
    }

    //addDrugsToDirectHospitalCurrentStock
    public Integer addDrugsToDirectHospitalCurrentStock(Direct_Hospital_Current_Stock direct_hospital_current_stock){
        direct_hospital_current_stockRepository.save(direct_hospital_current_stock);
//        direct_hospital_current_stockRepository.updateAvailableStock(direct_hospital_current_stock.getBatch_id());
        return 1;
    }

    //deleteDrugsFromDirectHospitalCurrentStock
}
