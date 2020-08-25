package com.example.pharmanic.repositories;


import java.util.List;
import java.util.Optional;

//import com.example.pharmanic.model.Ministry_Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.pharmanic.model.ERole;
import com.example.pharmanic.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);

    @Query(value="select name from roles",nativeQuery=true)
    public List<String> getRoleNames();
}