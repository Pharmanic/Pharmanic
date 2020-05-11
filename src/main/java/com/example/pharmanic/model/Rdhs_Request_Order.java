package com.example.pharmanic.model;

import com.example.pharmanic.Ministry_Store;
import com.example.pharmanic.Rdhs;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.sql.Date;
import java.util.Set;

@Data
@Entity
public class Rdhs_Request_Order {
    private @Id @GeneratedValue Long order_id;

    private Date date;

    @ManyToMany
    private Set<Rdhs> rdhs_reg_no;

    @ManyToMany
    private Set<Ministry_Store> m_store_id;

    public Rdhs_Request_Order() {
    }

    public Rdhs_Request_Order(Date date, Set<Rdhs> rdhs_reg_no, Set<Ministry_Store> m_store_id) {
        this.date = date;
        this.rdhs_reg_no = rdhs_reg_no;
        this.m_store_id = m_store_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Rdhs> getRdhs_reg_no() {
        return rdhs_reg_no;
    }

    public void setRdhs_reg_no(Set<Rdhs> rdhs_reg_no) {
        this.rdhs_reg_no = rdhs_reg_no;
    }

    public Set<Ministry_Store> getM_store_id() {
        return m_store_id;
    }

    public void setM_store_id(Set<Ministry_Store> m_store_id) {
        this.m_store_id = m_store_id;
    }
}
