package com.example.pharmanic.services;

import com.example.pharmanic.model.Rdhs_Current_Stock;
import com.example.pharmanic.repositories.Rdhs_Current_StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Rdhs_Current_StockService {
    @Autowired
    Rdhs_Current_StockRepository rdhs_current_stockRepository;

    public Integer addDrugsToRdhs(Long x){
        try{
            rdhs_current_stockRepository.updateRdhscurrentstock(x);
        }catch (NullPointerException ex){

        }


        return 1;
    }

    public List<Rdhs_Current_Stock> getallRdhsCurrentStock(){
        return rdhs_current_stockRepository.findAll();
    }


}
