package com.example.pharmanic.model;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Ministry_User extends User {

    @ManyToOne
    @JoinColumn(name = "ministry_id",referencedColumnName = "ministry_id")
    private Ministry ministry;


    public Ministry_User() {
    }

    public Ministry_User(Long nic, String first_name, String last_name, String tel_no, String email, String address, String password, Integer status, Integer role, Ministry ministry) {
        super(nic, first_name, last_name, tel_no, email, address, password, status, role);
        this.ministry = ministry;
    }

    public Ministry getMinistry() {
        return ministry;
    }

    public void setMinistry(Ministry ministry) {
        this.ministry = ministry;
    }




}