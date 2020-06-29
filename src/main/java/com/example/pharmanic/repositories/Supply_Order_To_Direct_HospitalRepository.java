package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Supply_Order_To_Direct_Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Supply_Order_To_Direct_HospitalRepository extends JpaRepository<Supply_Order_To_Direct_Hospital,Long> {

    @Query(value="{call close_dhreq_order(:o_id)}",nativeQuery=true)
    public void closeDHReqOrder(@Param("o_id") Long o_id);
}
