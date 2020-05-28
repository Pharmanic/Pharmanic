package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Direct_Hospital_Current_Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Direct_Hospital_Current_StockRepository extends JpaRepository<Direct_Hospital_Current_Stock, Long> {

    @Query(value="select * from direct_hospital_current_stock u where batch_id = :batch_id", nativeQuery=true)
    public Direct_Hospital_Current_Stock findByBatch_id(@Param("batch_id") Long batch_id);
}
