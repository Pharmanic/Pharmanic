package com.example.pharmanic.model;

import com.example.pharmanic.Medicine;
import com.example.pharmanic.Ministry_Store;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.sql.Date;
import java.time.Instant;
import java.util.Set;

@Data
@Entity
public class Ministry_Current_Stock {
    private @Id @GeneratedValue Long batch_id;

    @NonNull
    private Date expire_date;
    private String name;
    private Long available_quantity;

    @ManyToMany
    private Set<Ministry_Store> m_store_id;

    @ManyToMany
    private Set<Medicine> sr_no;

    public Ministry_Current_Stock() {
    }

    public Ministry_Current_Stock(Date expire_date, String name, Long available_quantity, Set<Ministry_Store> m_store_id, Set<Medicine> sr_no) {
        this.expire_date = expire_date;
        this.name = name;
        this.available_quantity = available_quantity;
        this.m_store_id = m_store_id;
        this.sr_no = sr_no;
    }

    public Long getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(Long batch_id) {
        this.batch_id = batch_id;
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
