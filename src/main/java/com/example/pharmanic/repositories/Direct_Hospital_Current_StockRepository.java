package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Direct_Hospital_Current_Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface Direct_Hospital_Current_StockRepository extends JpaRepository<Direct_Hospital_Current_Stock, Long> {

    @Query(value="select * from direct_hospital_current_stock u where id = :id", nativeQuery=true)
    public Optional<Direct_Hospital_Current_Stock> findById(@Param("id") Long id);
}
