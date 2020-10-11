package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Rdhs_Current_Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Rdhs_Current_StockRepository extends JpaRepository<Rdhs_Current_Stock,Long> {
    @Query(value="{call confirm_orders_rdhs(:x)}",nativeQuery=true)
    public void updateRdhscurrentstock(@Param("x") Long x);
}
