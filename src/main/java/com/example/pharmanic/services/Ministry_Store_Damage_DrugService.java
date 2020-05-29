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
        try{
            ministry_current_stockRepository.updateDamageStock(ministry_store_damage_drug.getBatch_id().getBatch_id(),ministry_store_damage_drug.getQuantity());
        }catch (NullPointerException ex){

        }
        return 1;
    }

    public Ministry_Store_Damage_Drug updateMinistryDamageStock(Ministry_Store_Damage_Drug ministry_store_damage_drug) {
        if (ministry_store_damage_drugRepository.existsById(ministry_store_damage_drug.getDid())) {
            try{
                ministry_store_damage_drugRepository.damageupdate(ministry_store_damage_drug.getDid(),ministry_store_damage_drug.getBatch_id().getBatch_id(),ministry_store_damage_drug.getQuantity());
            }catch(NullPointerException ex){

            }
            return ministry_store_damage_drugRepository.save(ministry_store_damage_drug);
        }

        return new Ministry_Store_Damage_Drug();
    }

    public String deleteministryDamageStock(Long did) {
        if (did != null) {
            if (ministry_store_damage_drugRepository.existsById(did)) {
                try{
                    ministry_store_damage_drugRepository.damagedelete(did);
                }catch(NullPointerException ex){

                }

                ministry_store_damage_drugRepository.deleteById(did);
                return "success";
            }
        }
        return "error";
    }




}
