package com.example.pharmanic.model;

import com.example.pharmanic.Medicine;
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
public class Ministry_Store_Damage_Drug {
    private @Id @GeneratedValue Long did;

    private Date date;
    private String name;
    private Long quantity;
    private Date expire_date;
    private String reason;

    @ManyToMany
    private Set<Ministry_Store> m_store_id;

    @ManyToMany Set<Medicine> sr_no;

    public Ministry_Store_Damage_Drug() {
    }

    public Ministry_Store_Damage_Drug(Date date, String name, Long quantity, Date expire_date, String reason, Set<Ministry_Store> m_store_id, Set<Medicine> sr_no) {
        this.date = date;
        this.name = name;
        this.quantity = quantity;
        this.expire_date = expire_date;
        this.reason = reason;
        this.m_store_id = m_store_id;
        this.sr_no = sr_no;
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<Ministry_Store> getM_store_id() {
        return m_store_id;
    }

    public void setM_store_id(Set<Ministry_Store> m_store_id) {
        this.m_store_id = m_store_id;
    }

    public Set<Medicine> getSr_no() {
        return sr_no;
    }

    public void setSr_no(Set<Medicine> sr_no) {
        this.sr_no = sr_no;
    }
}
