package com.example.pharmanic.web;

import com.example.pharmanic.model.Rdhs;
import com.example.pharmanic.model.User_Detail;
import com.example.pharmanic.model.User_Detail_Interface;
import com.example.pharmanic.repositories.RdhsRepository;
import com.example.pharmanic.services.RdhsService;
import com.example.pharmanic.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class UserConrtoller {

//    @Autowired
//    RdhsRepository rdhsRepository;

    @Autowired
    UserService userService;

    @GetMapping("/user_list")
    public List<User_Detail_Interface> getUSerDetailsList()
    {
        System.out.println("USer details Controller");
        return userService.getUserDetailsList();
    }


}
