package com.example.pharmanic.repositories;


import java.util.List;
import java.util.Optional;

import com.example.pharmanic.model.User_Detail_Interface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.pharmanic.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    @Query(value="select username,email,branch,name FROM users u inner join user_roles ur on u.id=ur.user_id inner join roles r on ur.role_id=r.id;",nativeQuery=true)
    public List<User_Detail_Interface> getUserDetails();
}