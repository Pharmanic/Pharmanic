package com.example.pharmanic.services;

import com.example.pharmanic.model.Direct_Hospital;
import com.example.pharmanic.model.Direct_Hospital_Request_Order;
import com.example.pharmanic.model.Direct_Hospital_Request_Order_Detail;
import com.example.pharmanic.model.Ministry_Current_Stock;
import com.example.pharmanic.repositories.Direct_Hospital_Request_OrderRepository;
import com.example.pharmanic.repositories.Direct_Hospital_Request_Order_DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;

@Service
public class Direct_Hospital_Request_OrderService {

    @Autowired
    Direct_Hospital_Request_OrderRepository direct_hospital_request_orderRepository;

    @Autowired
    Direct_Hospital_Request_Order_DetailRepository direct_hospital_request_order_detailRepository;

    //getDirectHospitalRequstOrders
    public List<Direct_Hospital_Request_Order> getDirectHospitalRequestOrderList(){
        List<Direct_Hospital_Request_Order> direct_hospital_request_orderList=direct_hospital_request_orderRepository.findAll();
        return direct_hospital_request_orderList;
    }

    //getDirectHospitalRequstOrders
    public List<Direct_Hospital_Request_Order> getDirectHospitalPendingOrderList(){
        List<Direct_Hospital_Request_Order> direct_hospital_request_orderList=direct_hospital_request_orderRepository.pendingorderlist();
        return direct_hospital_request_orderList;
    }

    //getDirectHospitalRequstOrders
    public List<Direct_Hospital_Request_Order> getnotcompleteDirectHospitalRequestOrderList(){
        List<Direct_Hospital_Request_Order> direct_hospital_request_orderList=direct_hospital_request_orderRepository.reqorderlist();
        return direct_hospital_request_orderList;
    }

    //addDirectHospitalRequestOrder
    public Integer addDirectHospitalRequestOrder(Direct_Hospital_Request_Order direct_hospital_request_order){
        direct_hospital_request_orderRepository.save(direct_hospital_request_order);
        return 1;
    }

    //getDirectHospitalRequstOrders
    public List<Direct_Hospital_Request_Order_Detail> getDHReqOrderDetailList(Long id){
        List<Direct_Hospital_Request_Order_Detail> direct_hospital_request_order_detailList=direct_hospital_request_order_detailRepository.selectreqorderdetails(id);
        return direct_hospital_request_order_detailList;
    }

    //getDirectHospitalRequstOrders
    public List<Direct_Hospital_Request_Order_Detail> getDHReqOrderDetailSuppliedList(Long id){
        List<Direct_Hospital_Request_Order_Detail> direct_hospital_request_order_detailList=direct_hospital_request_order_detailRepository.selectreqorderdetailssupplied(id);
        return direct_hospital_request_order_detailList;
    }

    //addDirectHospitalRequestOrder
    public Integer addDirectHospitalRequestDetailOrder(Direct_Hospital_Request_Order_Detail direct_hospital_request_order_detail){
        direct_hospital_request_order_detailRepository.save(direct_hospital_request_order_detail);
        try{
            direct_hospital_request_order_detailRepository.cansullpyorder(direct_hospital_request_order_detail.getId(),direct_hospital_request_order_detail.getOrder_id().getM_store_id().getM_store_id(),direct_hospital_request_order_detail.getQuantity(), direct_hospital_request_order_detail.getSr_no().getSr_no());

        }catch(NullPointerException ex){

        }


//        direct_hospital_request_order_detailRepository.cansullpyorder(direct_hospital_request_order_detail.getOrder_id().getOrder_id(),
//                                                        direct_hospital_request_order_detail.getOrder_id().getM_store_id().getM_store_id(),
//                                                        direct_hospital_request_order_detail.getQuantity(),
//                                                        direct_hospital_request_order_detail.getSr_no().getSr_no());
        return 1;
    }

    public Integer updateStatus(Direct_Hospital_Request_Order_Detail direct_hospital_request_order_detail){
        return 1;
    }

    //getOrderDetail
    public Direct_Hospital_Request_Order_Detail getDirectHospitalOrderDetail(Long id){
        if(id != null){
            if (direct_hospital_request_order_detailRepository.existsById(id)){
                return direct_hospital_request_order_detailRepository.findByID(id);
            }
        }
        return new Direct_Hospital_Request_Order_Detail();
    }


}
