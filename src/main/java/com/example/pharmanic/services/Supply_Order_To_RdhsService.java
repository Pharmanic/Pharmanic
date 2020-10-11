package com.example.pharmanic.services;

import com.example.pharmanic.model.Supply_Order_To_Direct_Hospital;
import com.example.pharmanic.model.Supply_Order_To_Rdhs;
import com.example.pharmanic.repositories.Rdhs_Request_Order_DetailRepository;
import com.example.pharmanic.repositories.Supply_Order_To_RdhsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Supply_Order_To_RdhsService {

    @Autowired
    Supply_Order_To_RdhsRepository supply_order_to_rdhsRepository;

    @Autowired
    Rdhs_Request_Order_DetailRepository rdhs_request_order_detailRepository;


    public Integer addSupplyOrderToRdhs(Supply_Order_To_Rdhs supply_order_to_rdhs){
        supply_order_to_rdhsRepository.save(supply_order_to_rdhs);
        try{
            rdhs_request_order_detailRepository.sypplyordersrdhs(supply_order_to_rdhs.getRequest_id().getId(),supply_order_to_rdhs.getRequest_id().getQuantity(),supply_order_to_rdhs.getRequest_id().getSr_no().getSr_no(),supply_order_to_rdhs.getRequest_id().getOrder_id().getM_store_id().getM_store_id());
        }catch (NullPointerException ex){

        }
        return 1;
    }


}
