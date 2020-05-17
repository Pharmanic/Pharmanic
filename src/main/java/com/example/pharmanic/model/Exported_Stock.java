package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Data
@Entity
public class Exported_Stock {
    private @Id String stock_id;

    private Date export_date;
    private Date order_date;

    public Exported_Stock() {
    }

    public Exported_Stock(String stock_id, Date export_date, Date order_date) {
        this.stock_id = stock_id;
        this.export_date = export_date;
        this.order_date = order_date;
    }

    public String getStock_id() {
        return stock_id;
    }

    public void setStock_id(String stock_id) {
        this.stock_id = stock_id;
    }

    public Date getExport_date() {
        return export_date;
    }

    public void setExport_date(Date export_date) {
        this.export_date = export_date;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    @Override
    public String toString() {
        return "Exported_Stock{" +
                "stock_id='" + stock_id + '\'' +
                ", export_date=" + export_date +
                ", order_date=" + order_date +
                '}';
    }
}
