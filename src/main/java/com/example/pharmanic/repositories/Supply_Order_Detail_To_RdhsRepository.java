package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Supply_Order_Detail_To_Rdhs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;

public interface Supply_Order_Detail_To_RdhsRepository extends JpaRepository<Supply_Order_Detail_To_Rdhs,Long> {

    @Query(value="SELECT sum(quantity) FROM supply_order_detail_to_rdhs where date = :date group by date",nativeQuery=true)
    public Integer getDailySupplyToRDHS(@Param("date") Date date);

    @Query(value="SELECT sum(quantity) FROM pharmanic.rdhs_request_order d inner join pharmanic.rdhs_request_order_detail dd on d.order_id=dd.order_id where date=:date group by date;",nativeQuery=true)
    public Integer getDailyRequestsFromRDHS(@Param("date") Date date);


}
