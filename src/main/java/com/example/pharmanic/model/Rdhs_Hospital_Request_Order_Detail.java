package com.example.pharmanic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "Rdhs_Hospital_Request_Order_Detail")
public class Rdhs_Hospital_Request_Order_Detail {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long odId;
    private int qty;
    @Column(nullable = true)
    private int state;

    @ManyToOne
    @JoinColumn(name = "sr_no", nullable = false, referencedColumnName = "sr_no")
    private Medicine medicine;

    @ManyToOne
    @JoinColumn(name = "orderId",nullable = false,referencedColumnName = "orderId")
    private Rdhs_Hospital_Request_Order rdhs_hospital_request_order;

}
