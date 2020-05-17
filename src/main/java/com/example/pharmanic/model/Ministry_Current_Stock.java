package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Ministry_Current_Stock {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long batch_id;

    @ManyToOne
    @JoinColumn(name = "stock_id",referencedColumnName = "stock_id")
    private Exported_Stock stock_id;

    @ManyToOne
    @JoinColumn(name = "m_store_id",referencedColumnName = "m_store_id")
    private Ministry_Store m_store_id;

    @ManyToOne
    @JoinColumn(name = "sr_no",referencedColumnName = "sr_no")
    private Medicine sr_no;

    private Date expire_date;
    private String name;
    private Long available_quantity;

    public Ministry_Current_Stock() {
    }

    public Ministry_Current_Stock(Long batch_id, Exported_Stock stock_id, Ministry_Store m_store_id, Medicine sr_no, Date expire_date, String name, Long available_quantity) {
        this.batch_id = batch_id;
        this.stock_id = stock_id;
        this.m_store_id = m_store_id;
        this.sr_no = sr_no;
        this.expire_date = expire_date;
        this.name = name;
        this.available_quantity = available_quantity;
    }

    public Long getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(Long batch_id) {
        this.batch_id = batch_id;
    }

    public Exported_Stock getStock_id() {
        return stock_id;
    }

    public void setStock_id(Exported_Stock stock_id) {
        this.stock_id = stock_id;
    }

    public Ministry_Store getM_store_id() {
        return m_store_id;
    }

    public void setM_store_id(Ministry_Store m_store_id) {
        this.m_store_id = m_store_id;
    }

    public Medicine getSr_no() {
        return sr_no;
    }

    public void setSr_no(Medicine sr_no) {
        this.sr_no = sr_no;
    }

    public Date getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(Date expire_date) {
        this.expire_date = expire_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAvailable_quantity() {
        return available_quantity;
    }

    public void setAvailable_quantity(Long available_quantity) {
        this.available_quantity = available_quantity;
    }

    @Override
    public String toString() {
        return "Ministry_Current_Stock{" +
                "batch_id=" + batch_id +
                ", stock_id=" + stock_id +
                ", m_store_id=" + m_store_id +
                ", sr_no=" + sr_no +
                ", expire_date=" + expire_date +
                ", name='" + name + '\'' +
                ", available_quantity=" + available_quantity +
                '}';
    }
}
