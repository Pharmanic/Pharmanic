package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Direct_Hospital_Request_Order;
import com.example.pharmanic.model.Rdhs_Request_Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Rdhs_Request_OrderRepository extends JpaRepository<Rdhs_Request_Order,Long> {
    @Query(value="{call new_rdhs_order_notification()}",nativeQuery=true)
    public List<Rdhs_Request_Order> reqorderlist();
}
