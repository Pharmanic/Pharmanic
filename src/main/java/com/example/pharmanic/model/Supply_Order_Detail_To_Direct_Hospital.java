package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Supply_Order_Detail_To_Direct_Hospital {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    @ManyToOne
    @JoinColumn(name = "supply_id",referencedColumnName = "supply_id")
    private Supply_Order_To_Rdhs order_id;

    @ManyToOne
    @JoinColumn(name="batch_id",referencedColumnName = "batch_id")
    private Ministry_Current_Stock batch_id;

    private Long quantity;

    public Supply_Order_Detail_To_Direct_Hospital() {
    }

    public Supply_Order_Detail_To_Direct_Hospital(Long id, Supply_Order_To_Rdhs order_id, Ministry_Current_Stock batch_id, Long quantity) {
        this.id = id;
        this.order_id = order_id;
        this.batch_id = batch_id;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Supply_Order_To_Rdhs getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Supply_Order_To_Rdhs order_id) {
        this.order_id = order_id;
    }

    public Ministry_Current_Stock getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(Ministry_Current_Stock batch_id) {
        this.batch_id = batch_id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Supply_Order_Detail_To_Direct_Hospital{" +
                "id=" + id +
                ", order_id=" + order_id +
                ", batch_id=" + batch_id +
                ", quantity=" + quantity +
                '}';
    }
}
