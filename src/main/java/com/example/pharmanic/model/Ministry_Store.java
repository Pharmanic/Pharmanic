package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Ministry_Store {
    private @Id String m_store_id;

    private String name;

    private String email;

    private String tel_no;

    private String location;

    private Integer total_storage;

    private Integer available_storage;

//    @OneToOne
//    @JoinColumn(name = "ministry_store_incharge",referencedColumnName = "nic")
//    private Ministry_Store_User ministry_store_incharge;

    public Ministry_Store() {
    }

    public Ministry_Store(String m_store_id, String name, String email, String tel_no, String location, Integer total_storage, Integer available_storage) {
        this.m_store_id = m_store_id;
        this.name = name;
        this.email = email;
        this.tel_no = tel_no;
        this.location = location;
        this.total_storage = total_storage;
        this.available_storage = available_storage;
    }

    public void setM_store_id(String m_store_id) {
        this.m_store_id = m_store_id;
    }

    public String getM_store_id() {
        return m_store_id;
    }

    public Integer getTotal_storage() {
        return total_storage;
    }

    public void setTotal_storage(Integer total_storage) {
        this.total_storage = total_storage;
    }

    public Integer getAvilable_storage() {
        return available_storage;
    }

    public void setAvilable_storage(Integer avilable_storage) {
        this.available_storage = avilable_storage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel_no() {
        return tel_no;
    }

    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
    }

    public Integer getAvailable_storage() {
        return available_storage;
    }

    public void setAvailable_storage(Integer available_storage) {
        this.available_storage = available_storage;
    }

//    public Ministry_Store_User getMinistry_store_incharge() {
//        return ministry_store_incharge;
//    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Ministry_Store{" +
                "m_store_id=" + m_store_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", tel_no='" + tel_no + '\'' +
                ", location='" + location + '\'' +
                ", total_storage=" + total_storage +
                ", available_storage=" + available_storage +
//                ", ministry_store_incharge=" + ministry_store_incharge +
                '}';
    }
}
