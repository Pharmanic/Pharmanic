package com.example.pharmanic.repositories;

import com.example.pharmanic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface User_BaseRepository<T extends User>
        extends JpaRepository<T,String> {

    //public T findByEmail(String email);

}
