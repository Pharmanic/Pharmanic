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
    public Direct_Hospital_Current_Stock addDrugsToDirectHospitalCurrentStock(Direct_Hospital_Current_Stock direct_hospital_current_stock){
        return direct_hospital_current_stockRepository.save(direct_hospital_current_stock);
    }

    //updateDirectHospitalCurrentStock
    public Direct_Hospital_Current_Stock updateDirectHospitalCurrentStock(Direct_Hospital_Current_Stock direct_hospital_current_stock){
        if(isExists(direct_hospital_current_stock)) return direct_hospital_current_stockRepository.save(direct_hospital_current_stock);
        return null;
    }

    public boolean isExists(Direct_Hospital_Current_Stock direct_hospital_current_stock){
        if(direct_hospital_current_stockRepository.findById(direct_hospital_current_stock.getBatch_id()).get()!=null) return true;
        return false;
    }

    //deleteDrugsFromDirectHospitalCurrentStock
    public Integer deleteDirectHospitalCurrentStock(Long batch_id){
        if(direct_hospital_current_stockRepository.findById(batch_id).get()!=null){
            direct_hospital_current_stockRepository.deleteById(batch_id);
            return 1;
        }
        return 0;
    }
}
