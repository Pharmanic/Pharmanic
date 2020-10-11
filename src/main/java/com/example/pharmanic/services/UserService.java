package com.example.pharmanic.services;

import com.example.pharmanic.model.User;
import com.example.pharmanic.model.Rdhs;
import com.example.pharmanic.model.User_Detail;
import com.example.pharmanic.model.User_Detail_Interface;
import com.example.pharmanic.repositories.RdhsRepository;
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
    public List<User_Detail_Interface> getUserDetailsList(){
        System.out.println("User Details List in service");

        List<User_Detail_Interface> userList=userRepository.getUserDetails();
//        System.out.println(userList.get(0)+userList.get(0).toString()+"User Details List"+userList.get(0).getUserName()+"  "+userList.get(0).getBranch()+"  "+userList.get(0).getEMail()+"  "+userList.get(0).getName());
        return userList;
    }


//    //getRdhsDetails
//    public Rdhs getRdhsDetails(String reg_no){
//        if (reg_no !=null){
//            if (userRepository.existsById(reg_no)){
//                return userRepository.findById(reg_no).get();
//            }
//        }
//        return new Rdhs();
//    }
//    public Rdhs addRdhs(Rdhs newRdhs){
//        return userRepository.save(newRdhs);
//    }
//
//    public Rdhs updateRdhs(Rdhs rdhs){
//        if(isExixts(rdhs))
//             return userRepository.save(rdhs);
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
//
//    //getRdhsDetails
//    public Rdhs getRdhsByName(String name){
//        if (name !=null){
//            if (rdhsRepository.existsById(name)){
//                return rdhsRepository.findByName(name);
//            }
//        }
//        return new Rdhs();
//    }
}
