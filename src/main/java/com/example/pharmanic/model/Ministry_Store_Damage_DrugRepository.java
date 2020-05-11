package com.example.pharmanic.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Ministry_Store_Damage_DrugRepository extends JpaRepository<Ministry_Store_Damage_Drug,Long> {
    Ministry_Store_Damage_Drug findByName(String name);
}
