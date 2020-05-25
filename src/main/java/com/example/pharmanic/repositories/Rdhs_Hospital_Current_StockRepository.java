package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Rdhs_Hospital_Current_Stock;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Rdhs_Hospital_Current_StockRepository extends JpaRepository<Rdhs_Hospital_Current_Stock,Long> {
 Rdhs_Hospital_Current_Stock findBybatchId(Long id);


}
