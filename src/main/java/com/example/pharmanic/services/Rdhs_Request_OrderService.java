package com.example.pharmanic.services;

import com.example.pharmanic.model.Direct_Hospital_Request_Order;
import com.example.pharmanic.model.Direct_Hospital_Request_Order_Detail;
import com.example.pharmanic.model.Rdhs_Request_Order;
import com.example.pharmanic.model.Rdhs_Request_Order_Detail;
import com.example.pharmanic.repositories.Rdhs_Request_OrderRepository;
import com.example.pharmanic.repositories.Rdhs_Request_Order_DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Rdhs_Request_OrderService {

    @Autowired
    Rdhs_Request_OrderRepository rdhs_request_orderRepository;

    @Autowired
    Rdhs_Request_Order_DetailRepository rdhs_request_order_detailRepository;

    //getRDHSRequestOrders
    public List<Rdhs_Request_Order> getRDHSRequestOrderList(){
        List<Rdhs_Request_Order> rdhs_request_orderList=rdhs_request_orderRepository.findAll();
        return rdhs_request_orderList;
    }

    //getDRDHSRequstOrders
    public List<Rdhs_Request_Order_Detail> getRDHSReqOrderDetailSuppliedList(Long id){
        List<Rdhs_Request_Order_Detail> rdhs_request_order_detailList=rdhs_request_order_detailRepository.selectreqorderdetailssupplied(id);
        return rdhs_request_order_detailList;
    }

    public List<Rdhs_Request_Order> getRdhsPendingOrderList(){
        List<Rdhs_Request_Order> rdhs_request_orderList=rdhs_request_orderRepository.pendingorderlist();
        return rdhs_request_orderList;
    }


    //getDirectHospitalRequstOrders
    public List<Rdhs_Request_Order> getnotcompleteRdhsRequestOrderList(){
        List<Rdhs_Request_Order> rdhs_request_orderList=rdhs_request_orderRepository.rdhsreqorder();
        return rdhs_request_orderList;
    }

    //addRdhsRequestOrder
    public Integer addRdhsRequestOrder(Rdhs_Request_Order rdhs_request_order){
        rdhs_request_orderRepository.save(rdhs_request_order);
        return 1;
    }

    //getRdhsRequstOrders
    public List<Rdhs_Request_Order_Detail> getRDHSReqOrderDetailList(String id){
        List<Rdhs_Request_Order_Detail> rdhs_request_order_detailList=rdhs_request_order_detailRepository.selectreqorderdetails(id);
        return rdhs_request_order_detailList;
    }

    public Integer addRdhsRequestDetailOrder(Rdhs_Request_Order_Detail rdhs_request_order_detail){
        rdhs_request_order_detailRepository.save(rdhs_request_order_detail);
        try{
            rdhs_request_order_detailRepository.cansullpyorder(rdhs_request_order_detail.getId(),rdhs_request_order_detail.getOrder_id().getM_store_id().getM_store_id(),rdhs_request_order_detail.getQuantity(), rdhs_request_order_detail.getSr_no().getSr_no());

        }catch(NullPointerException ex){

        }
        return 1;
    }

    public Integer updateStatus(Rdhs_Request_Order_Detail rdhs_request_order_detail){
        return 1;
    }

    //getOrderDetail
    public Rdhs_Request_Order_Detail getRdhsOrderDetail(Long id){
        if(id != null){
            if (rdhs_request_order_detailRepository.existsById(id)){
                return rdhs_request_order_detailRepository.findByID(id);
            }
        }
        return new Rdhs_Request_Order_Detail();
    }
}