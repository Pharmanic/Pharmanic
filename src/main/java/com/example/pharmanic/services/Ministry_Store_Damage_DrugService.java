package com.example.pharmanic.services;

import com.example.pharmanic.model.Ministry_Current_Stock;
import com.example.pharmanic.model.Ministry_Store_Damage_Drug;
import com.example.pharmanic.repositories.Ministry_Current_StockRepository;
import com.example.pharmanic.repositories.Ministry_Store_Damage_DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ministry_Store_Damage_DrugService {

    @Autowired
    Ministry_Store_Damage_DrugRepository ministry_store_damage_drugRepository;

    @Autowired
    Ministry_Current_StockRepository ministry_current_stockRepository;

    //getMinistryStoreDamageDrug
    public List<Ministry_Store_Damage_Drug> getMinistryDamageDrugStockList(){
        List<Ministry_Store_Damage_Drug> ministry_store_damage_drugList=ministry_store_damage_drugRepository.findAll();
        return ministry_store_damage_drugList;
    }

    //addDrugsToMinistryDamageStore
    public Integer addDrugsToMinistryDamageStock(Ministry_Store_Damage_Drug ministry_store_damage_drug){
        ministry_store_damage_drugRepository.save(ministry_store_damage_drug);
        ministry_current_stockRepository.updateDamageStock(ministry_store_damage_drug.getBatch_id().getBatch_id(),ministry_store_damage_drug.getQuantity());
        return 1;
    }

}
