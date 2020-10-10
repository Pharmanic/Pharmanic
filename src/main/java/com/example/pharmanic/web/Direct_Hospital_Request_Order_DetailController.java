package com.example.pharmanic.web;

import com.example.pharmanic.model.Direct_Hospital_Request_Order;
import com.example.pharmanic.model.Direct_Hospital_Request_Order_Detail;
import com.example.pharmanic.repositories.Direct_Hospital_Request_Order_DetailRepository;
import com.example.pharmanic.services.Direct_Hospital_Request_OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class Direct_Hospital_Request_Order_DetailController {

    @Autowired
    private Direct_Hospital_Request_Order_DetailRepository direct_hospital_request_order_detailRepository;

    @Autowired
    private Direct_Hospital_Request_OrderService direct_hospital_request_orderService;

    @GetMapping("/dhreqorderdetails/{id}")
    public List<Direct_Hospital_Request_Order_Detail> dhreqorderdetails(@PathVariable("id")  Long id){
        return direct_hospital_request_orderService.getDHReqOrderDetailList(id);
    }

    @GetMapping("/dhreqorderdetailssupplied/{id}")
    public List<Direct_Hospital_Request_Order_Detail> dhreqorderdetailssupplied(@PathVariable("id")  Long id){
        return direct_hospital_request_orderService.getDHReqOrderDetailSuppliedList(id);
    }

    @GetMapping("/dhreqorderdetail/{id}")
    public Direct_Hospital_Request_Order_Detail dhreqorderdetail(@PathVariable("id")  Long id){
        return direct_hospital_request_orderService.getDirectHospitalOrderDetail(id);
    }

//    @PostMapping("/availablestatus")
//    public Integer dhreqorderdetails(@RequestBody Direct_Hospital_Request_Order_Detail direct_hospital_request_order_detail){
//        return direct_hospital_request_orderService.whetherCanSupplyOrder(direct_hospital_request_order_detail);
//    }

    @PostMapping("/directhospitalrequestorderdetail/add")
    public Integer addDirectHospitalRequestOrderDetail(@RequestBody Direct_Hospital_Request_Order_Detail direct_hospital_request_order_detail){

        return direct_hospital_request_orderService.addDirectHospitalRequestDetailOrder(direct_hospital_request_order_detail);
    }

//
//    @GetMapping("/directhospitalrequestorderdetail/update")
//    public Integer updateStatus(@RequestBody Direct_Hospital_Request_Order_Detail direct_hospital_request_order_detail){
//
//        return direct_hospital_request_orderService.updateStatus(direct_hospital_request_order_detail);
//    }

//    @PostMapping("/acceptqorders/add")
//    public Integer adhreqorderdetail(@RequestBody Direct_Hospital_Request_Order_Detail direct_hospital_request_order_detail){
//        return direct_hospital_request_orderService.acceptOrderSupply(direct_hospital_request_order_detail);
//     //   return direct_hospital_request_orderService.getDirectHospitalOrderDetail(id);
//
//    }



}
