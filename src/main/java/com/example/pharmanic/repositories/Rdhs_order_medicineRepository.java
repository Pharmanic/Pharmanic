package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Rdhs_order_medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Rdhs_order_medicineRepository extends JpaRepository<Rdhs_order_medicine,String>{
    @Query(value="select *from Rdhs_order_medicine u where sr_no = :sr_no",nativeQuery=true)
        public Rdhs_order_medicine findBysr_no(@Param("sr_no") String sr_no);
}

