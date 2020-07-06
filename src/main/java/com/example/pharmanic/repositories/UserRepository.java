package com.example.pharmanic.repositories;

import com.example.pharmanic.model.User;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface UserRepository extends User_BaseRepository<User> {


}
