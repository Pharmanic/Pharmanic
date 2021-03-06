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
        return ministry_current_stockRepository.yearWiseCurrentImportStockAvg()/1000;
    }
    public Integer getYearlyImportMedicieAvg5(){
        System.out.println(ministry_current_stockRepository.yearWiseCurrentImportStock5Avg());
        return ministry_current_stockRepository.yearWiseCurrentImportStock5Avg()/1000;
    }
    public Integer getYearlyImportMedicieAvg10(){
        return ministry_current_stockRepository.yearWiseCurrentImportStock10Avg()/1000;
    }

    //getQtyYearList
    public String[] getYearlyAvailableMedicieSumYears5(){
        System.out.println("Yr Im Med Sum Servc");

        Integer[] yearWiseCurrentAvailableStockListInt=ministry_current_stockRepository.yearWiseCurrentAvailableStockYears5();
        String[] yearWiseCurrentAvailableStockList=new String[yearWiseCurrentAvailableStockListInt.length];
//        System.out.println(userList.get(0)+userList.get(0).toString()+"User Details List"+userList.get(0).getUserName()+"  "+userList.get(0).getBranch()+"  "+userList.get(0).getEMail()+"  "+userList.get(0).getName());
//        System.out.println("QTy Years"+yearWiseCurrentAvailableStockList.get(0).getYear());
        for(int i=0;i<yearWiseCurrentAvailableStockListInt.length;i++){
            yearWiseCurrentAvailableStockList[i]=yearWiseCurrentAvailableStockListInt[i].toString();
        }

        return yearWiseCurrentAvailableStockList;
    }
    public Integer[] getYearlyAvailableMedicieSum5(){
        System.out.println("Yr Im Med Sum Servc");

        Integer[] yearWiseCurrentAvailableStockList=ministry_current_stockRepository.yearWiseCurrentAvailableStock5();
//        System.out.println(userList.get(0)+userList.get(0).toString()+"User Details List"+userList.get(0).getUserName()+"  "+userList.get(0).getBranch()+"  "+userList.get(0).getEMail()+"  "+userList.get(0).getName());
//        System.out.println("QTy Years"+yearWiseCurrentAvailableStockList.get(0).getYear());
        return yearWiseCurrentAvailableStockList;
    }

    //getQtyYearList
    public String[] getYearlyAvailableMedicieSumYears10(){
        System.out.println("Yr Im Med Sum Servc");

        Integer[] yearWiseCurrentAvailableStockListInt=ministry_current_stockRepository.yearWiseCurrentAvailableStockYears10();
        String[] yearWiseCurrentAvailableStockList=new String[yearWiseCurrentAvailableStockListInt.length];
//        System.out.println(userList.get(0)+userList.get(0).toString()+"User Details List"+userList.get(0).getUserName()+"  "+userList.get(0).getBranch()+"  "+userList.get(0).getEMail()+"  "+userList.get(0).getName());
//        System.out.println("QTy Years"+yearWiseCurrentAvailableStockList.get(0).getYear());
        for(int i=0;i<yearWiseCurrentAvailableStockListInt.length;i++){
            yearWiseCurrentAvailableStockList[i]=yearWiseCurrentAvailableStockListInt[i].toString();
        }

        return yearWiseCurrentAvailableStockList;
    }
    public Integer[] getYearlyAvailableMedicieSum10(){
        System.out.println("Yr Im Med Sum Servc");

        Integer[] yearWiseCurrentAvailableStockList=ministry_current_stockRepository.yearWiseCurrentAvailableStock10();
//        System.out.println(userList.get(0)+userList.get(0).toString()+"User Details List"+userList.get(0).getUserName()+"  "+userList.get(0).getBranch()+"  "+userList.get(0).getEMail()+"  "+userList.get(0).getName());
//        System.out.println("QTy Years"+yearWiseCurrentAvailableStockList.get(0).getYear());
        return yearWiseCurrentAvailableStockList;
    }

    //getQtyYearList
    public String[] getYearlyAvailableMedicieSumYears(){
        System.out.println("Yr Im Med Sum Servc");

        Integer[] yearWiseCurrentAvailableStockListInt=ministry_current_stockRepository.yearWiseCurrentAvailableStockYears();
        String[] yearWiseCurrentAvailableStockList=new String[yearWiseCurrentAvailableStockListInt.length];
//        System.out.println(userList.get(0)+userList.get(0).toString()+"User Details List"+userList.get(0).getUserName()+"  "+userList.get(0).getBranch()+"  "+userList.get(0).getEMail()+"  "+userList.get(0).getName());
//        System.out.println("QTy Years"+yearWiseCurrentAvailableStockList.get(0).getYear());
        for(int i=0;i<yearWiseCurrentAvailableStockListInt.length;i++){
            yearWiseCurrentAvailableStockList[i]=yearWiseCurrentAvailableStockListInt[i].toString();
        }

        return yearWiseCurrentAvailableStockList;
    }
    public Integer[] getYearlyAvailableMedicieSum(){
        System.out.println("Yr Im Med Sum Servc");

        Integer[] yearWiseCurrentAvailableStockList=ministry_current_stockRepository.yearWiseCurrentAvailableStock();
//        System.out.println(userList.get(0)+userList.get(0).toString()+"User Details List"+userList.get(0).getUserName()+"  "+userList.get(0).getBranch()+"  "+userList.get(0).getEMail()+"  "+userList.get(0).getName());
//        System.out.println("QTy Years"+yearWiseCurrentAvailableStockList.get(0).getYear());
        return yearWiseCurrentAvailableStockList;
    }
    public Integer getYearlyAvailableMedicieAvg(){
        return ministry_current_stockRepository.yearWiseCurrentAvailableStockAvg()/1000;
    }

    public Integer getYearlyAvailableMedicieAvg5(){
        System.out.println(ministry_current_stockRepository.yearWiseCurrentAvailableStock5Avg());
        return ministry_current_stockRepository.yearWiseCurrentAvailableStock5Avg()/1000;
    }
    public Integer getYearlyAvailableMedicieAvg10(){
        return ministry_current_stockRepository.yearWiseCurrentAvailableStock10Avg()/1000;
    }

    //getQtyYearList
    public String[] getYearlySupplyedMedicieSumYears(){
        System.out.println("Yr Im Med Sum Servc");

        Integer[] yearWiseCurrentAvailableStockListInt=ministry_current_stockRepository.yearWiseCurrentSuppliedStockYears();
        String[] yearWiseCurrentAvailableStockList=new String[yearWiseCurrentAvailableStockListInt.length];
//        System.out.println(userList.get(0)+userList.get(0).toString()+"User Details List"+userList.get(0).getUserName()+"  "+userList.get(0).getBranch()+"  "+userList.get(0).getEMail()+"  "+userList.get(0).getName());
//        System.out.println("QTy Years"+yearWiseCurrentAvailableStockList.get(0).getYear());
        for(int i=0;i<yearWiseCurrentAvailableStockListInt.length;i++){
            yearWiseCurrentAvailableStockList[i]=yearWiseCurrentAvailableStockListInt[i].toString();
        }

        return yearWiseCurrentAvailableStockList;
    }

    public Integer[] getYearlySupplyedMedicieSum(){
        System.out.println("Yr Im Med Sum Servc");

        Integer[] yearWiseCurrentAvailableStockList=ministry_current_stockRepository.yearWiseCurrentSuppliedStock();
//        System.out.println(userList.get(0)+userList.get(0).toString()+"User Details List"+userList.get(0).getUserName()+"  "+userList.get(0).getBranch()+"  "+userList.get(0).getEMail()+"  "+userList.get(0).getName());
//        System.out.println("QTy Years"+yearWiseCurrentAvailableStockList.get(0).getYear());
        return yearWiseCurrentAvailableStockList;
    }

    public Integer getYearlySupplyedMedicieAvg(){
        return ministry_current_stockRepository.yearWiseCurrentSuppliedStockAvg()/1000;
    }

    public String[] getYearlySupplyedMedicieSumYears5(){
        System.out.println("Yr Im Med Sum Servc");

        Integer[] yearWiseCurrentAvailableStockListInt=ministry_current_stockRepository.yearWiseCurrentSuppliedStockYears5();
        String[] yearWiseCurrentAvailableStockList=new String[yearWiseCurrentAvailableStockListInt.length];
//        System.out.println(userList.get(0)+userList.get(0).toString()+"User Details List"+userList.get(0).getUserName()+"  "+userList.get(0).getBranch()+"  "+userList.get(0).getEMail()+"  "+userList.get(0).getName());
//        System.out.println("QTy Years"+yearWiseCurrentAvailableStockList.get(0).getYear());
        for(int i=0;i<yearWiseCurrentAvailableStockListInt.length;i++){
            yearWiseCurrentAvailableStockList[i]=yearWiseCurrentAvailableStockListInt[i].toString();
        }

        return yearWiseCurrentAvailableStockList;
    }

    public Integer[] getYearlySupplyedMedicieSum5(){
        System.out.println("Yr Im Med Sum Servc");

        Integer[] yearWiseCurrentAvailableStockList=ministry_current_stockRepository.yearWiseCurrentSuppliedStock5();
//        System.out.println(userList.get(0)+userList.get(0).toString()+"User Details List"+userList.get(0).getUserName()+"  "+userList.get(0).getBranch()+"  "+userList.get(0).getEMail()+"  "+userList.get(0).getName());
//        System.out.println("QTy Years"+yearWiseCurrentAvailableStockList.get(0).getYear());
        return yearWiseCurrentAvailableStockList;
    }

    public Integer getYearlySupplyedMedicieAvg5(){
        return ministry_current_stockRepository.yearWiseCurrentSuppliedStockAvg5()/1000;
    }

    public String[] getYearlySupplyedMedicieSumYears10(){
        System.out.println("Yr Im Med Sum Servc");

        Integer[] yearWiseCurrentAvailableStockListInt=ministry_current_stockRepository.yearWiseCurrentSuppliedStockYears10();
        String[] yearWiseCurrentAvailableStockList=new String[yearWiseCurrentAvailableStockListInt.length];
//        System.out.println(userList.get(0)+userList.get(0).toString()+"User Details List"+userList.get(0).getUserName()+"  "+userList.get(0).getBranch()+"  "+userList.get(0).getEMail()+"  "+userList.get(0).getName());
//        System.out.println("QTy Years"+yearWiseCurrentAvailableStockList.get(0).getYear());
        for(int i=0;i<yearWiseCurrentAvailableStockListInt.length;i++){
            yearWiseCurrentAvailableStockList[i]=yearWiseCurrentAvailableStockListInt[i].toString();
        }

        return yearWiseCurrentAvailableStockList;
    }

    public Integer[] getYearlySupplyedMedicieSum10(){
        System.out.println("Yr Im Med Sum Servc");

        Integer[] yearWiseCurrentAvailableStockList=ministry_current_stockRepository.yearWiseCurrentSuppliedStock10();
//        System.out.println(userList.get(0)+userList.get(0).toString()+"User Details List"+userList.get(0).getUserName()+"  "+userList.get(0).getBranch()+"  "+userList.get(0).getEMail()+"  "+userList.get(0).getName());
//        System.out.println("QTy Years"+yearWiseCurrentAvailableStockList.get(0).getYear());
        return yearWiseCurrentAvailableStockList;
    }

    public Integer getYearlySupplyedMedicieAvg10(){
        return ministry_current_stockRepository.yearWiseCurrentSuppliedStockAvg10()/1000;
    }

    public String[] getYearlyDamagedMedicieSumYears(){
        System.out.println("Yr Im Med Sum Servc");

        Integer[] yearWiseCurrentAvailableStockListInt=ministry_current_stockRepository.yearWiseCurrentDamagedStockYears();
        String[] yearWiseCurrentAvailableStockList=new String[yearWiseCurrentAvailableStockListInt.length];
//        System.out.println(userList.get(0)+userList.get(0).toString()+"User Details List"+userList.get(0).getUserName()+"  "+userList.get(0).getBranch()+"  "+userList.get(0).getEMail()+"  "+userList.get(0).getName());
//        System.out.println("QTy Years"+yearWiseCurrentAvailableStockList.get(0).getYear());
        for(int i=0;i<yearWiseCurrentAvailableStockListInt.length;i++){
            yearWiseCurrentAvailableStockList[i]=yearWiseCurrentAvailableStockListInt[i].toString();
        }

        return yearWiseCurrentAvailableStockList;
    }

    public Integer[] getYearlyDamagedMedicieSum(){
        System.out.println("Yr Im Med Sum Servc");

        Integer[] yearWiseCurrentAvailableStockList=ministry_current_stockRepository.yearWiseCurrentDamagedStock();
//        System.out.println(userList.get(0)+userList.get(0).toString()+"User Details List"+userList.get(0).getUserName()+"  "+userList.get(0).getBranch()+"  "+userList.get(0).getEMail()+"  "+userList.get(0).getName());
//        System.out.println("QTy Years"+yearWiseCurrentAvailableStockList.get(0).getYear());
        return yearWiseCurrentAvailableStockList;
    }

    public Integer getYearlyDamagedMedicieAvg(){
        return ministry_current_stockRepository.yearWiseCurrentDamagedStockAvg()/1000;
    }

    public String[] getYearlyDamagedMedicieSumYears5(){
        System.out.println("Yr Im Med Sum Servc");

        Integer[] yearWiseCurrentAvailableStockListInt=ministry_current_stockRepository.yearWiseCurrentDamagedStockYears5();
        String[] yearWiseCurrentAvailableStockList=new String[yearWiseCurrentAvailableStockListInt.length];
//        System.out.println(userList.get(0)+userList.get(0).toString()+"User Details List"+userList.get(0).getUserName()+"  "+userList.get(0).getBranch()+"  "+userList.get(0).getEMail()+"  "+userList.get(0).getName());
//        System.out.println("QTy Years"+yearWiseCurrentAvailableStockList.get(0).getYear());
        for(int i=0;i<yearWiseCurrentAvailableStockListInt.length;i++){
            yearWiseCurrentAvailableStockList[i]=yearWiseCurrentAvailableStockListInt[i].toString();
        }

        return yearWiseCurrentAvailableStockList;
    }

    public Integer[] getYearlyDamagedMedicieSum5(){
        System.out.println("Yr Im Med Sum Servc");

        Integer[] yearWiseCurrentAvailableStockList=ministry_current_stockRepository.yearWiseCurrentDamagedStock5();
//        System.out.println(userList.get(0)+userList.get(0).toString()+"User Details List"+userList.get(0).getUserName()+"  "+userList.get(0).getBranch()+"  "+userList.get(0).getEMail()+"  "+userList.get(0).getName());
//        System.out.println("QTy Years"+yearWiseCurrentAvailableStockList.get(0).getYear());
        return yearWiseCurrentAvailableStockList;
    }

    public Integer getYearlyDamagedMedicieAvg5(){
        return ministry_current_stockRepository.yearWiseCurrentDamagedStockAvg5()/1000;
    }

    public String[] getYearlyDamagedMedicieSumYears10(){
        System.out.println("Yr Im Med Sum Servc");

        Integer[] yearWiseCurrentAvailableStockListInt=ministry_current_stockRepository.yearWiseCurrentDamagedStockYears10();
        String[] yearWiseCurrentAvailableStockList=new String[yearWiseCurrentAvailableStockListInt.length];
//        System.out.println(userList.get(0)+userList.get(0).toString()+"User Details List"+userList.get(0).getUserName()+"  "+userList.get(0).getBranch()+"  "+userList.get(0).getEMail()+"  "+userList.get(0).getName());
//        System.out.println("QTy Years"+yearWiseCurrentAvailableStockList.get(0).getYear());
        for(int i=0;i<yearWiseCurrentAvailableStockListInt.length;i++){
            yearWiseCurrentAvailableStockList[i]=yearWiseCurrentAvailableStockListInt[i].toString();
        }

        return yearWiseCurrentAvailableStockList;
    }

    public Integer[] getYearlyDamagedMedicieSum10(){
        System.out.println("Yr Im Med Sum Servc");

        Integer[] yearWiseCurrentAvailableStockList=ministry_current_stockRepository.yearWiseCurrentDamagedStock10();
//        System.out.println(userList.get(0)+userList.get(0).toString()+"User Details List"+userList.get(0).getUserName()+"  "+userList.get(0).getBranch()+"  "+userList.get(0).getEMail()+"  "+userList.get(0).getName());
//        System.out.println("QTy Years"+yearWiseCurrentAvailableStockList.get(0).getYear());
        return yearWiseCurrentAvailableStockList;
    }
    public Integer getYearlyDamagedMedicieAvg10() {
        return ministry_current_stockRepository.yearWiseCurrentDamagedStockAvg10()/1000;
    }

    public Integer getCurrentImportedStock(){
        return ministry_current_stockRepository.getCurrentImportStock();
    }
    public Integer getCurrentAvailableStock(){
        return ministry_current_stockRepository.getCurrentAvailableStock();
    }
    public Integer getCurrentDamagedStock(){
        return ministry_current_stockRepository.getCurrentDamagedStock();
    }
    public Integer getCurrentSuppliedStock(){
        return ministry_current_stockRepository.getCurrentSuppliedStock();
    }


    public Integer[] getTotalSuppliedStock(){
        return ministry_current_stockRepository.get_total_supplied_stock();
    }
    public Integer[] getTotalAvailableStock(){
        return ministry_current_stockRepository.get_total_available_stock();
    }
    public Integer[] getTotalDamagedStock(){
        return ministry_current_stockRepository.get_total_damaged_stock();
    }
    public Integer[] getDatesDailyCounts(){
        return ministry_current_stockRepository.getDatesDailyCounts();
    }

    public Integer[] getTotalSuppliedStock3(){
        return ministry_current_stockRepository.get_total_supplied_stock3();
    }
    public Integer[] getTotalAvailableStock3(){
        return ministry_current_stockRepository.get_total_available_stock3();
    }
    public Integer[] getTotalDamagedStock3(){
        return ministry_current_stockRepository.get_total_damaged_stock3();
    }
    public Integer[] getDatesDailyCounts3(){
        return ministry_current_stockRepository.getDatesDailyCounts3();
    }



}
