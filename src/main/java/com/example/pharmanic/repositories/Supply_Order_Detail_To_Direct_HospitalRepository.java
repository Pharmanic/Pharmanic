package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Ministry_Store;
import com.example.pharmanic.model.Supply_Order_Detail_To_Direct_Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;

public interface Supply_Order_Detail_To_Direct_HospitalRepository extends JpaRepository<Supply_Order_Detail_To_Direct_Hospital,Long> {

//    @Query(value="SELECT sum(quantity) FROM supply_order_detail_to_direct_hospital group by date;",nativeQuery=true)
//    public Integer getDailySupplyToDirectHospital();
    @Query(value="SELECT sum(quantity) FROM supply_order_detail_to_direct_hospital where date = :date group by date",nativeQuery=true)
    public Integer getDailySupplyToDirectHospital(@Param("date") Date date);

    @Query(value="SELECT date FROM supply_order_detail_to_rdhs union distinct SELECT date FROM supply_order_detail_to_direct_hospital union distinct SELECT date from direct_hospital_request_order union distinct SELECT date from rdhs_hospital_request_order  order by date limit 7;",nativeQuery=true)
    public Date[] getDate();

    @Query(value="SELECT sum(quantity) FROM pharmanic.direct_hospital_request_order d inner join pharmanic.direct_hospital_request_order_detail dd on d.order_id=dd.order_id where date=:date group by date;",nativeQuery=true)
    public Integer getDailyRequestsFromDirectHospital(@Param("date") Date date);


}
