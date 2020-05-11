package com.example.pharmanic.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Ministry_Current_StockRepository extends JpaRepository<Ministry_Current_Stock,Long> {
    Ministry_Current_Stock findByName(String name);
}
