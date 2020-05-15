package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Rdhs_Request_Order_Detail {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "order_id")
    private Rdhs_Request_Order order_id;

    @ManyToOne
    @JoinColumn(name = "sr_no",referencedColumnName = "sr_no")
    private Medicine sr_no;

    private String name;
    private Long quantity;

    public Rdhs_Request_Order_Detail() {
    }

    public Rdhs_Request_Order_Detail(Long id, Rdhs_Request_Order order_id, Medicine sr_no, String name, Long quantity) {
        this.id = id;
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

    public Rdhs_Request_Order getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Rdhs_Request_Order order_id) {
        this.order_id = order_id;
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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Rdhs_Request_Order_Detail{" +
                "id=" + id +
                ", order_id=" + order_id +
                ", sr_no=" + sr_no +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
