package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Ministry_Store {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long m_store_id;

    private String location;

    private Integer total_storage;

    private Integer available_storage;

    @OneToOne
    @JoinColumn(name = "nic",referencedColumnName = "nic")
    private Ministry_Store_User ministry_store_incharge;

    public Ministry_Store() {
    }

    public Ministry_Store(Long m_store_id, String location, Integer total_storage, Integer avilable_storage, Ministry_Store_User ministry_store_incharge) {
        this.m_store_id = m_store_id;
        this.location = location;
        this.total_storage = total_storage;
        this.available_storage = avilable_storage;
        this.ministry_store_incharge = ministry_store_incharge;
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

    public void setMinistry_store_incharge(Ministry_Store_User ministry_store_incharge) {
        this.ministry_store_incharge = ministry_store_incharge;
    }

    public Ministry_Store_User getMinistry_store_incharge() {
        return ministry_store_incharge;
    }

    public Long getM_store_id() {
        return m_store_id;
    }

    public void setM_store_id(Long m_store_id) {
        this.m_store_id = m_store_id;
    }

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
                ", location='" + location + '\'' +
                '}';
    }
}
