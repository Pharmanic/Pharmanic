package com.example.pharmanic.services;

import com.example.pharmanic.model.Ministry_Driver;
import com.example.pharmanic.model.Ministry_Store;
import com.example.pharmanic.model.Rdhs;
import com.example.pharmanic.repositories.Ministry_DriverRepository;
import com.example.pharmanic.repositories.Ministry_StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ministry_StoreService {

    @Autowired
    Ministry_StoreRepository ministry_storeRepository;

    //getMinistryStoreList
    public List<Ministry_Store> getMinistryStoreList(){
        List<Ministry_Store> ministry_storeList=ministry_storeRepository.findAll();
        return ministry_storeList;
    }

    //getMinistryStoreDetails
    public Ministry_Store getMinistryStoreDetails(String m_store_id){
        if (m_store_id !=null){
            if (ministry_storeRepository.existsById(m_store_id)){
                return ministry_storeRepository.findByM_store_id(m_store_id);
            }
        }
        return new Ministry_Store();
    }

    public Ministry_Store addMinistryStore(Ministry_Store newMinistry_Store){
        return ministry_storeRepository.save(newMinistry_Store);
    }

    public Ministry_Store updateMinistryStore(Ministry_Store ministry_store){
        if(isExixts(ministry_store))
            return ministry_storeRepository.save(ministry_store);
        return null;
    }

    public boolean isExixts(Ministry_Store ministry_store){
        if(ministry_storeRepository.findById(ministry_store.getM_store_id()).get()!=null)
            return true;
        return false;
    }

    public Integer deleteMinistryStore(String ministry_id){
        if(ministry_storeRepository.findById(ministry_id).get()!=null) {
            ministry_storeRepository.deleteById(ministry_id);
            return 1;
        }
        return 0;
    }

    public Integer getMinistryStoreCount(){
        return ministry_storeRepository.getMinistryStoreCount();

    }
}
