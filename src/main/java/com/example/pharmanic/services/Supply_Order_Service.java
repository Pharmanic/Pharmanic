package com.example.pharmanic.services;

import com.example.pharmanic.model.Supply_Order_Detail_To_Direct_Hospital;
import com.example.pharmanic.model.Supply_Order_To_Rdhs;
import com.example.pharmanic.repositories.Rdhs_Request_Order_DetailRepository;
import com.example.pharmanic.repositories.Supply_Order_Detail_To_Direct_HospitalRepository;
import com.example.pharmanic.repositories.Supply_Order_Detail_To_RdhsRepository;
import com.example.pharmanic.repositories.Supply_Order_To_RdhsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class Supply_Order_Service {

    @Autowired
    Supply_Order_Detail_To_RdhsRepository supply_order_to_rdhs;
    @Autowired
    Supply_Order_Detail_To_Direct_HospitalRepository supply_order_to_directHospital;

    public Integer[] getWeeklySupplyDetails(){

        Date[] curDate=supply_order_to_directHospital.getDate();
        Integer[] totalSupplies=new Integer[curDate.length];
        int s=0,r=0;
        for(int i=0;i<curDate.length;i++){
            System.out.println(curDate[i]+"In Sypply ");
            if(supply_order_to_rdhs.getDailySupplyToRDHS(curDate[i])!=null){
                s=supply_order_to_rdhs.getDailySupplyToRDHS(curDate[i])/1000;
            }else{
                s=0;
            }
            System.out.println("This is s"+s);
            if(supply_order_to_directHospital.getDailySupplyToDirectHospital(curDate[i])!=null){
                r=supply_order_to_directHospital.getDailySupplyToDirectHospital(curDate[i])/1000;
            }else{
                r=0;
            }

            System.out.println("This is r"+r);

            totalSupplies[i]=s+r;
        }

        return totalSupplies; // total supply array
    }

    public Integer[] getWeeklyDemandDetails(){

        Date[] curDate=supply_order_to_directHospital.getDate();
        Integer[] totalRequests=new Integer[curDate.length];
        int s=0,r=0;
        for(int i=0;i<curDate.length;i++){
            System.out.println(curDate[i]+"In Sypply ");
            if(supply_order_to_rdhs.getDailyRequestsFromRDHS(curDate[i])!=null){
                s=supply_order_to_rdhs.getDailyRequestsFromRDHS(curDate[i])/1000;
            }else{
                s=0;
            }
            System.out.println("This is s"+s);
            if(supply_order_to_directHospital.getDailyRequestsFromDirectHospital(curDate[i])!=null){
                r=supply_order_to_directHospital.getDailyRequestsFromDirectHospital(curDate[i])/1000;
            }else{
                r=0;
            }

            System.out.println("This is r"+r);

            totalRequests[i]=s+r;
        }

        return totalRequests; // total supply array
    }

    public Date[] getWeeklySupplyDays() {

        return supply_order_to_directHospital.getDate();
    }

    public Integer getDirectYearlySupplyCount(){

        return supply_order_to_directHospital.getDirectYearsSupplyCount();

    }

    public Integer getRDHSYearlySupplyCount(){

        return supply_order_to_rdhs.getRDHSYearsSupplyCount();

    }

    public Integer getRDHSYearsDemandCount(){
        System.out.println(supply_order_to_rdhs.getRDHSYearsDemandCount());
        return supply_order_to_rdhs.getRDHSYearsDemandCount();

    }

    public Integer getDirectYearsDemandCount(){
        System.out.println(supply_order_to_directHospital.getDirectYearsDemandCount());
        return supply_order_to_directHospital.getDirectYearsDemandCount();

    }


}
