package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Direct_Hospital_Request_Order;
import com.example.pharmanic.model.Ministry_Current_Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Direct_Hospital_Request_OrderRepository extends JpaRepository<Direct_Hospital_Request_Order,Long> {
    @Query(value="{call new_dh_order_notification()}",nativeQuery=true)
    public List<Direct_Hospital_Request_Order> reqorderlist();

    @Query(value="{call get_pending_orders_dh()}",nativeQuery=true)
    public List<Direct_Hospital_Request_Order> pendingorderlist();

}
