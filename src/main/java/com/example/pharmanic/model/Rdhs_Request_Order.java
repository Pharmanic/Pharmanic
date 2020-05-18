package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Rdhs_Request_Order {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long order_id;

    @ManyToOne
    @JoinColumn(name = "reg_no",referencedColumnName = "reg_no")
    private Rdhs rdhs_reg_no;

    @ManyToOne
    @JoinColumn(name = "m_store_id",referencedColumnName = "m_store_id")
    private Ministry_Store m_store_id;

    private Date date;
    private int state;

    public Rdhs_Request_Order() {
    }

    public Rdhs_Request_Order(Long order_id, Rdhs rdhs_reg_no, Ministry_Store m_store_id, Date date, int state) {
        this.order_id = order_id;
        this.rdhs_reg_no = rdhs_reg_no;
        this.m_store_id = m_store_id;
        this.date = date;
        this.state = state;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Rdhs getRdhs_reg_no() {
        return rdhs_reg_no;
    }

    public void setRdhs_reg_no(Rdhs rdhs_reg_no) {
        this.rdhs_reg_no = rdhs_reg_no;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Rdhs_Request_Order{" +
                "order_id=" + order_id +
                ", rdhs_reg_no=" + rdhs_reg_no +
                ", m_store_id=" + m_store_id +
                ", date=" + date +
                ", state=" + state +
                '}';
    }
}
