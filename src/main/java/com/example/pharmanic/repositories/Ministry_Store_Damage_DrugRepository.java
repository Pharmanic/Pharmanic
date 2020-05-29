package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Ministry_Store_Damage_Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Ministry_Store_Damage_DrugRepository extends JpaRepository<Ministry_Store_Damage_Drug,Long> {
    @Query(value="{call ministry_store_damage_update(:id, :bid, :x)}",nativeQuery=true)
    public Integer damageupdate(@Param("id") Long id, @Param("bid") Long bid, @Param("x") Long x);

    @Query(value="{call ministry_store_damage_delete(:id)}",nativeQuery=true)
    public Integer damagedelete(@Param("id") Long id);

}
