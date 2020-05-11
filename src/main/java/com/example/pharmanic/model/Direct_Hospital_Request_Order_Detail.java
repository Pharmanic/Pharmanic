package com.example.pharmanic.model;

import com.example.pharmanic.Medicine;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Data
@Entity
public class Direct_Hospital_Request_Order_Detail {
    private @Id @GeneratedValue Long id;

    @ManyToMany
    private Set<Direct_Hospital_Request_Order> order_id;

    @ManyToMany
    private Set<Medicine> sr_no;

    private String name;
    private Long quantity;

    public Direct_Hospital_Request_Order_Detail() {
    }

    public Direct_Hospital_Request_Order_Detail(Set<Direct_Hospital_Request_Order> order_id, Set<Medicine> sr_no, String name, Long quantity) {
        this.order_id = order_id;
        this.sr_no = sr_no;
        this.name = name;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Direct_Hospital_Request_Order> getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Set<Direct_Hospital_Request_Order> order_id) {
        this.order_id = order_id;
    }

    public Set<Medicine> getSr_no() {
        return sr_no;
    }

    public void setSr_no(Set<Medicine> sr_no) {
        this.sr_no = sr_no;
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
}
