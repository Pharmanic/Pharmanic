package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Rdhs_Hospital_Request_Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Rdhs_Hospital_Request_OrderRepository extends JpaRepository<Rdhs_Hospital_Request_Order,Long> {
    @Query(value = "select order_id from Rdhs_Hospital_Request_Order  order by order_id desc limit 1",nativeQuery = true)
    Long findNextId();
}
