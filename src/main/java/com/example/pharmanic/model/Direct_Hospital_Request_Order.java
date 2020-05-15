package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Direct_Hospital_Request_Order {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long order_id;

    @ManyToOne
    @JoinColumn(name = "reg_no",referencedColumnName = "reg_no")
    private Direct_Hospital hospital_reg_no;

    @ManyToOne
    @JoinColumn(name = "m_store_id",referencedColumnName = "m_store_id")
    private Ministry_Store m_store_id;

    private Date date;

    public Direct_Hospital_Request_Order() {
    }

    public Direct_Hospital_Request_Order(Long order_id, Direct_Hospital hospital_reg_no, Ministry_Store m_store_id, Date date) {
        this.order_id = order_id;
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

    public Direct_Hospital getHospital_reg_no() {
        return hospital_reg_no;
    }

    public void setHospital_reg_no(Direct_Hospital hospital_reg_no) {
        this.hospital_reg_no = hospital_reg_no;
    }

    public Ministry_Store getM_store_id() {
        return m_store_id;
    }

    public void setM_store_id(Ministry_Store m_store_id) {
        this.m_store_id = m_store_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Direct_Hospital_Request_Order{" +
                "order_id=" + order_id +
                ", hospital_reg_no=" + hospital_reg_no +
                ", m_store_id=" + m_store_id +
                ", date=" + date +
                '}';
    }
}
