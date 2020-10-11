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

    @Query(value="SELECT sum(quantity)/1000 FROM pharmanic.supply_order_detail_to_rdhs where year(date)=year(curdate());",nativeQuery=true)
    public Integer getRDHSYearsSupplyCount();

    @Query(value="SELECT sum(quantity)/1000 FROM pharmanic.rdhs_request_order d inner join pharmanic.rdhs_request_order_detail dd on d.order_id=dd.order_id where year(date)=year(curdate());",nativeQuery=true)
    public Integer getRDHSYearsDemandCount();

    @Query(value="SELECT sum(qty)/1000 FROM rdhs_hospital_request_order_detail rd inner join rdhs_hospital_request_order r on r.order_id=rd.order_id where year(date)=year(curdate()) and state=0;",nativeQuery=true)
    public Integer getDemand();

    @Query(value="SELECT sum(qty)/1000 FROM rdhs_hospital_request_order_detail rd inner join rdhs_hospital_request_order r on r.order_id=rd.order_id where year(date)=year(curdate()) and state=1;",nativeQuery=true)
    public Integer getSupply();

    @Query(value="SELECT sum(quantity)/1000 FROM supply_order_detail_to_rdhs where year(date)=year(curdate());",nativeQuery=true)
    public Integer gettotalSupplytoRDHS();

    @Query(value="SELECT sum(qty)/1000 FROM pharmanic.rdhs_hospital_request_order_detail rd inner join pharmanic.rdhs_hospital_request_order r on rd.order_id=r.order_id where state=0 and year(date)=year(curdate());",nativeQuery=true)
    public Integer gettotalSupplytoRDHSHospital();

    @Query(value="SELECT sum(quantity)/1000 FROM supply_order_detail_to_direct_hospital where year(date)=year(curdate());",nativeQuery=true)
    public Integer gettotalSupplytoDirectHospital();




}
