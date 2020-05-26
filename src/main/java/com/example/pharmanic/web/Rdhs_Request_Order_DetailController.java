package com.example.pharmanic.web;

import com.example.pharmanic.model.Direct_Hospital_Request_Order_Detail;
import com.example.pharmanic.model.Rdhs_Request_Order_Detail;
import com.example.pharmanic.repositories.Rdhs_Request_Order_DetailRepository;
import com.example.pharmanic.services.Rdhs_Request_OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class Rdhs_Request_Order_DetailController {

    @Autowired
    Rdhs_Request_OrderService rdhs_request_orderService;

    @Autowired
    Rdhs_Request_Order_DetailRepository rdhs_request_order_detailRepository;

    @GetMapping("/rdhsreqorderdetails/{id}")
    public List<Rdhs_Request_Order_Detail> rdhsreqorderdetails(@PathVariable("id")  Long id){
        return rdhs_request_orderService.getRDHSReqOrderDetailList(id);
    }

    @GetMapping("/rdhsreqorderdetail/{id}")
    public Rdhs_Request_Order_Detail rdhsreqorderdetail(@PathVariable("id")  Long id){
        return rdhs_request_orderService.getRdhsOrderDetail(id);
    }


    @PostMapping("/rdhsrequestorderdetail/add")
    public Integer addRdhsRequestOrderDetail(@RequestBody Rdhs_Request_Order_Detail rdhs_request_order_detail){
        return rdhs_request_orderService.addRdhsRequestDetailOrder(rdhs_request_order_detail);
    }

}
