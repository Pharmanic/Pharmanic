package com.example.pharmanic.model;

import com.example.pharmanic.Direct_Hospital;
import com.example.pharmanic.Ministry_Store;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.sql.Date;
import java.util.Set;

@Data
@Entity
public class Direct_Hospital_Request_Order {
    private @Id @GeneratedValue Long order_id;

    @ManyToMany
    private Set<Direct_Hospital> hospital_reg_no;

    @ManyToMany
    private Set<Ministry_Store> m_store_id;

    private Date date;

    public Direct_Hospital_Request_Order() {
    }

    public Direct_Hospital_Request_Order(Set<Direct_Hospital> hospital_reg_no, Set<Ministry_Store> m_store_id, Date date) {
        this.hospital_reg_no = hospital_reg_no;
        this.m_store_id = m_store_id;
        this.date = date;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Set<Direct_Hospital> getHospital_reg_no() {
        return hospital_reg_no;
    }

    public void setHospital_reg_no(Set<Direct_Hospital> hospital_reg_no) {
        this.hospital_reg_no = hospital_reg_no;
    }

    public Set<Ministry_Store> getM_store_id() {
        return m_store_id;
    }

    public void setM_store_id(Set<Ministry_Store> m_store_id) {
        this.m_store_id = m_store_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
