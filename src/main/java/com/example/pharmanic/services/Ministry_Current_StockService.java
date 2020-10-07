package com.example.pharmanic.services;

import com.example.pharmanic.model.Ministry_Current_Stock;
import com.example.pharmanic.model.QtyYear;
import com.example.pharmanic.model.User_Detail_Interface;
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

    //getQtyYearList
    public String[] getYearlyImportMedicieSumYears5(){
        System.out.println("Yr Im Med Sum Servc");

        Integer[] yearWiseCurrentImportStockListInt=ministry_current_stockRepository.yearWiseCurrentImportStockYears5();
        String[] yearWiseCurrentImportStockList=new String[yearWiseCurrentImportStockListInt.length];
//        System.out.println(userList.get(0)+userList.get(0).toString()+"User Details List"+userList.get(0).getUserName()+"  "+userList.get(0).getBranch()+"  "+userList.get(0).getEMail()+"  "+userList.get(0).getName());
//        System.out.println("QTy Years"+yearWiseCurrentImportStockList.get(0).getYear());
        for(int i=0;i<yearWiseCurrentImportStockListInt.length;i++){
            yearWiseCurrentImportStockList[i]=yearWiseCurrentImportStockListInt[i].toString();
        }

        return yearWiseCurrentImportStockList;
    }
    public Integer[] getYearlyImportMedicieSum5(){
        System.out.println("Yr Im Med Sum Servc");

        Integer[] yearWiseCurrentImportStockList=ministry_current_stockRepository.yearWiseCurrentImportStock5();
//        System.out.println(userList.get(0)+userList.get(0).toString()+"User Details List"+userList.get(0).getUserName()+"  "+userList.get(0).getBranch()+"  "+userList.get(0).getEMail()+"  "+userList.get(0).getName());
//        System.out.println("QTy Years"+yearWiseCurrentImportStockList.get(0).getYear());
        return yearWiseCurrentImportStockList;
    }

    //getQtyYearList
    public String[] getYearlyImportMedicieSumYears10(){
        System.out.println("Yr Im Med Sum Servc");

        Integer[] yearWiseCurrentImportStockListInt=ministry_current_stockRepository.yearWiseCurrentImportStockYears10();
        String[] yearWiseCurrentImportStockList=new String[yearWiseCurrentImportStockListInt.length];
//        System.out.println(userList.get(0)+userList.get(0).toString()+"User Details List"+userList.get(0).getUserName()+"  "+userList.get(0).getBranch()+"  "+userList.get(0).getEMail()+"  "+userList.get(0).getName());
//        System.out.println("QTy Years"+yearWiseCurrentImportStockList.get(0).getYear());
        for(int i=0;i<yearWiseCurrentImportStockListInt.length;i++){
            yearWiseCurrentImportStockList[i]=yearWiseCurrentImportStockListInt[i].toString();
        }

        return yearWiseCurrentImportStockList;
    }
    public Integer[] getYearlyImportMedicieSum10(){
        System.out.println("Yr Im Med Sum Servc");

        Integer[] yearWiseCurrentImportStockList=ministry_current_stockRepository.yearWiseCurrentImportStock10();
//        System.out.println(userList.get(0)+userList.get(0).toString()+"User Details List"+userList.get(0).getUserName()+"  "+userList.get(0).getBranch()+"  "+userList.get(0).getEMail()+"  "+userList.get(0).getName());
//        System.out.println("QTy Years"+yearWiseCurrentImportStockList.get(0).getYear());
        return yearWiseCurrentImportStockList;
    }

    //getQtyYearList
    public String[] getYearlyImportMedicieSumYears(){
        System.out.println("Yr Im Med Sum Servc");

        Integer[] yearWiseCurrentImportStockListInt=ministry_current_stockRepository.yearWiseCurrentImportStockYears();
        String[] yearWiseCurrentImportStockList=new String[yearWiseCurrentImportStockListInt.length];
//        System.out.println(userList.get(0)+userList.get(0).toString()+"User Details List"+userList.get(0).getUserName()+"  "+userList.get(0).getBranch()+"  "+userList.get(0).getEMail()+"  "+userList.get(0).getName());
//        System.out.println("QTy Years"+yearWiseCurrentImportStockList.get(0).getYear());
        for(int i=0;i<yearWiseCurrentImportStockListInt.length;i++){
            yearWiseCurrentImportStockList[i]=yearWiseCurrentImportStockListInt[i].toString();
        }

        return yearWiseCurrentImportStockList;
    }
    public Integer[] getYearlyImportMedicieSum(){
        System.out.println("Yr Im Med Sum Servc");

        Integer[] yearWiseCurrentImportStockList=ministry_current_stockRepository.yearWiseCurrentImportStock();
//        System.out.println(userList.get(0)+userList.get(0).toString()+"User Details List"+userList.get(0).getUserName()+"  "+userList.get(0).getBranch()+"  "+userList.get(0).getEMail()+"  "+userList.get(0).getName());
//        System.out.println("QTy Years"+yearWiseCurrentImportStockList.get(0).getYear());
        return yearWiseCurrentImportStockList;
    }

    public Integer getYearlyImportMedicieAvg(){
        return ministry_current_stockRepository.yearWiseCurrentImportStockAvg();
    }
    public Integer getYearlyImportMedicieAvg5(){
        System.out.println(ministry_current_stockRepository.yearWiseCurrentImportStock5Avg());
        return ministry_current_stockRepository.yearWiseCurrentImportStock5Avg();
    }
    public Integer getYearlyImportMedicieAvg10(){
        return ministry_current_stockRepository.yearWiseCurrentImportStock10Avg();
    }


}
