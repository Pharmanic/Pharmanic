package com.example.pharmanic.services;

import com.example.pharmanic.model.Direct_Hospital_Request_Order;
import com.example.pharmanic.model.Ministry_Current_Stock;
import com.example.pharmanic.model.Ministry_Track;
import com.example.pharmanic.model.Supply_Order_To_Direct_Hospital;
import com.example.pharmanic.repositories.Direct_Hospital_Request_Order_DetailRepository;
import com.example.pharmanic.repositories.Supply_Order_To_Direct_HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Supply_Order_To_Direct_HospitalService {

    @Autowired
    Supply_Order_To_Direct_HospitalRepository supply_order_to_direct_hospitalRepository;

    @Autowired
    Direct_Hospital_Request_Order_DetailRepository direct_hospital_request_order_detailRepository;

    //addDrivers
    public Integer addSupplyOrderToDirectHospital(Supply_Order_To_Direct_Hospital supply_order_to_direct_hospital){
        Supply_Order_To_Direct_Hospital object=supply_order_to_direct_hospital;
        object.setSupply_date(object.getTrack_id().getDate());
        supply_order_to_direct_hospitalRepository.save(object);
        try{
            direct_hospital_request_order_detailRepository.sypplyordersdirecthospital(supply_order_to_direct_hospital.getRequest_id().getId(),supply_order_to_direct_hospital.getRequest_id().getQuantity(),supply_order_to_direct_hospital.getRequest_id().getSr_no().getSr_no(),supply_order_to_direct_hospital.getRequest_id().getOrder_id().getM_store_id().getM_store_id());
        }catch (NullPointerException ex){

        }
        return 1;
    }

    //getsupply orderlist
    public List<Supply_Order_To_Direct_Hospital> getSupplyOrdersToDirectHospitals(){
        List<Supply_Order_To_Direct_Hospital> supply_order_to_direct_hospitals=supply_order_to_direct_hospitalRepository.findAll();
        return supply_order_to_direct_hospitals;
    }

    //closedirecthospitalreqorder
    public Integer closeorder(Long o_id){
        System.out.println("in service");
        Integer supplycount = supply_order_to_direct_hospitalRepository.suppliedcount(o_id);
        Integer orderdetailcount = supply_order_to_direct_hospitalRepository.orderdetailcont(o_id);
        System.out.println(supplycount);
        System.out.println(orderdetailcount);
        if(supplycount == orderdetailcount){
            supply_order_to_direct_hospitalRepository.closeDHReqOrder(o_id);
        }else{
            supply_order_to_direct_hospitalRepository.setorderstopending(o_id);
        }
       // supply_order_to_direct_hospitalRepository.closeDHReqOrder(o_id);
        return 1;
    }
}
