package com.example.pharmanic.services;

import com.example.pharmanic.repositories.Rdhs_Current_StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
