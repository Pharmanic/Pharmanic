package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Direct_Hospital_Request_Order_Detail {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "order_id")
    private Direct_Hospital_Request_Order order_id;

    @ManyToOne
    @JoinColumn(name = "sr_no",referencedColumnName = "sr_no")
    private Medicine sr_no;

    private Long quantity;
    private Long can_supply_status;
    private Long supply_status;

    public Direct_Hospital_Request_Order_Detail() {
    }


    public Direct_Hospital_Request_Order_Detail(Long id, Direct_Hospital_Request_Order order_id, Medicine sr_no, Long quantity, Long can_supply_status, Long supply_status) {
        this.id = id;
        this.order_id = order_id;
        this.sr_no = sr_no;
        this.quantity = quantity;
        this.can_supply_status = can_supply_status;
        this.supply_status = supply_status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Direct_Hospital_Request_Order getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Direct_Hospital_Request_Order order_id) {
        this.order_id = order_id;
    }

    public Medicine getSr_no() {
        return sr_no;
    }

    public void setSr_no(Medicine sr_no) {
        this.sr_no = sr_no;
    }


    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getCan_supply_status() {
        return can_supply_status;
    }

    public void setCan_supply_status(Long can_supply_status) {
        this.can_supply_status = can_supply_status;
    }

    public Long getSupply_status() {
        return supply_status;
    }

    public void setSupply_status(Long supply_status) {
        this.supply_status = supply_status;
    }

    @Override
    public String toString() {
        return "Direct_Hospital_Request_Order_Detail{" +
                "id=" + id +
                ", order_id=" + order_id +
                ", sr_no=" + sr_no +
                ", quantity=" + quantity +
                ", can_supply_status=" + can_supply_status +
                ", supply_status=" + supply_status +
                '}';
    }
}
