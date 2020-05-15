package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Ministry_Store_Damage_Drug {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long did;

    @ManyToOne
    @JoinColumn(name = "m_store_id",referencedColumnName = "m_store_id")
    private Ministry_Store m_store_id;

    @ManyToOne
    @JoinColumn(name = "sr_no",referencedColumnName = "sr_no")
    private Medicine sr_no;

    private String name;
    private Date date;
    private Long quantity;
    private Date expire_date;
    private String reason;

    public Ministry_Store_Damage_Drug() {
    }

    public Ministry_Store_Damage_Drug(Long did, Ministry_Store m_store_id, Medicine sr_no, String name, Date date, Long quantity, Date expire_date, String reason) {
        this.did = did;
        this.m_store_id = m_store_id;
        this.sr_no = sr_no;
        this.name = name;
        this.date = date;
        this.quantity = quantity;
        this.expire_date = expire_date;
        this.reason = reason;
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Date getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(Date expire_date) {
        this.expire_date = expire_date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Ministry_Store_Damage_Drug{" +
                "did=" + did +
                ", m_store_id=" + m_store_id +
                ", sr_no=" + sr_no +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", quantity=" + quantity +
                ", expire_date=" + expire_date +
                ", reason='" + reason + '\'' +
                '}';
    }
}
