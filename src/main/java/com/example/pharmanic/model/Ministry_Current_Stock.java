package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;


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
    private Long import_quantity;
    private Long supplyed_quantity;
    private Long damage_quantity;
    private Long available_quantity;

    public Ministry_Current_Stock() {
    }

    public Ministry_Current_Stock(Long batch_id, Exported_Stock stock_id, Ministry_Store m_store_id, Medicine sr_no, Date expire_date, String name, Long import_quantity, Long supplyed_quantity, Long damage_quantity, Long available_quantity) {
        this.batch_id = batch_id;
        this.stock_id = stock_id;
        this.m_store_id = m_store_id;
        this.sr_no = sr_no;
        this.expire_date = expire_date;
        this.name = name;
        this.import_quantity = import_quantity;
        this.supplyed_quantity = supplyed_quantity;
        this.damage_quantity = damage_quantity;
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

    public Long getImport_quantity() {
        return import_quantity;
    }

    public void setImport_quantity(Long import_quantity) {
        this.import_quantity = import_quantity;
    }

    public Long getSupplyed_quantity() {
        return supplyed_quantity;
    }

    public void setSupplyed_quantity(Long supplyed_quantity) {
        this.supplyed_quantity = supplyed_quantity;
    }

    public Long getDamage_quantity() {
        return damage_quantity;
    }

    public void setDamage_quantity(Long damage_quantity) {
        this.damage_quantity = damage_quantity;
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
                ", import_quantity=" + import_quantity +
                ", supplyed_quantity=" + supplyed_quantity +
                ", damage_quantity=" + damage_quantity +
                ", available_quantity=" + available_quantity +
                '}';
    }
}
