package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Direct_Hospital_Current_Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Direct_Hospital_Current_StockRepository extends JpaRepository<Direct_Hospital_Current_Stock, Long> {

//    @Query(value="{call direct_hospital_available_quantity(:id)}", nativeQuery=true)
//    public void updateAvailableStock(@Param("id") Long id);
}
