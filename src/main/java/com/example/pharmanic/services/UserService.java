package com.example.pharmanic.services;

import com.example.pharmanic.model.User;
import com.example.pharmanic.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    //getUserList
    public List<User> getAllUsers(){
        List<User> userList=userRepository.findAll();
        return userList;
    }

    //getUserDetails
    public User getUserDetails(String nic){
        if (nic !=null){
            if (userRepository.existsById(nic)){
                return userRepository.findById(nic).get();
            }
        }
        return null;
    }
//    public User addUser(User newUser){
//        return rdhsRepository.save(newRdhs);
//    }
//
//    public Rdhs updateRdhs(Rdhs rdhs){
//        if(isExixts(rdhs))
//             return rdhsRepository.save(rdhs);
//        return null;
//    }
//
//    public boolean isExixts(Rdhs rdhs){
//        if(rdhsRepository.findById(rdhs.getReg_no()).get()!=null)
//            return true;
//        return false;
//    }
//
//    public Integer deleteRdhs(String reg_no){
//        if(rdhsRepository.findById(reg_no).get()!=null) {
//            rdhsRepository.deleteById(reg_no);
//            return 1;
//    }
//        return 0;
//    }
}
