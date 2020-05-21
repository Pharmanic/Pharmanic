package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Direct_Hospital;
import com.example.pharmanic.model.Ministry_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Ministry_User_Repository extends JpaRepository<Ministry_User,String> {


}
