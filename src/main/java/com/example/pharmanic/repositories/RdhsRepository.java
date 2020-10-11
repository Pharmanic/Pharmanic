package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Ministry_Vehicle;
import com.example.pharmanic.model.Rdhs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RdhsRepository extends JpaRepository<Rdhs,String> {

    @Query(value="select *from rdhs u where name = :name",nativeQuery=true)
    public Rdhs findByName(@Param("name") String name);

    @Query(value="select count(reg_no) from rdhs",nativeQuery=true)
    public Integer getRdhsCount();

}
