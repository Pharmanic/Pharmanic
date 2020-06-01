package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Ministry_Driver;
import com.example.pharmanic.model.Ministry_Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Ministry_StoreRepository extends JpaRepository<Ministry_Store,String> {

    @Query(value="select *from ministry_store u where m_store_id = :m_store_id",nativeQuery=true)
    public Ministry_Store findByM_store_id(@Param("m_store_id") String m_store_id);
}
