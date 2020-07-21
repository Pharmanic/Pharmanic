package com.example.pharmanic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "LM_Hospital_Request_Order_Cart")
public class LM_Hospital_Request_Order_Cart {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long cartId;
    private Integer qty;
    @Column(nullable = true)
    private Integer state;

    @ManyToOne
    @JoinColumn(name = "reg_no", nullable = false, referencedColumnName = "reg_no")
    private Direct_Hospital direct_hospital;


    @ManyToOne
    @JoinColumn(name = "sr_no", nullable = false, referencedColumnName = "sr_no")
    private Medicine medicine;


}
