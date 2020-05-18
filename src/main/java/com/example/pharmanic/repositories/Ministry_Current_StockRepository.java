package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Ministry_Current_Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Ministry_Current_StockRepository extends JpaRepository<Ministry_Current_Stock,Long> {

    @Query(value="{call ministry_store_damage(:id, :quantity)}",nativeQuery=true)
    public void updateDamageStock(@Param("id") Long id,@Param("quantity") Long quantity);

    @Query(value="{call ministry_available_quantity(:id)}",nativeQuery=true)
    public void updateAvailableStock(@Param("id") Long id);

}
