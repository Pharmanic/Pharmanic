package com.example.pharmanic.services;

import com.example.pharmanic.model.Rdhs_Damage_Stock;
import com.example.pharmanic.repositories.Rdhs_Damage_StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Rdhs_Damage_StockService {
    @Autowired
    Rdhs_Damage_StockRepository rdhs_damage_stockRepository;
    //getMinistryStoreDamageDrug
    public List<Rdhs_Damage_Stock> getRdhsDamageDrugStockList(){
        List<Rdhs_Damage_Stock> rdhs_damage_drugList=rdhs_damage_stockRepository.findAll();
        return rdhs_damage_drugList;
    }

    //addDrugsToMinistryDamageStore
    public Integer addDrugsToRdhsDamageStock(Rdhs_Damage_Stock rdhs_damage_stock){
        rdhs_damage_stockRepository.save(rdhs_damage_stock);
        return 1;
    }}
