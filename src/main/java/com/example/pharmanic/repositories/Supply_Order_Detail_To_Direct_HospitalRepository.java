package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Supply_Order_Detail_To_Direct_Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Supply_Order_Detail_To_Direct_HospitalRepository extends JpaRepository<Supply_Order_Detail_To_Direct_Hospital,Long> {

    @Query(value="SELECT sum(quantity) FROM supply_order_detail_to_direct_hospital group by date;",nativeQuery=true)
    public Integer getDailySupplyToDirectHospital();
}
