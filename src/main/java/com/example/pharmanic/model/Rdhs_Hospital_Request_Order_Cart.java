package com.example.pharmanic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "Rdhs_Hospital_Request_Order_Cart")
public class Rdhs_Hospital_Request_Order_Cart {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long cartId;
    private Integer qty;
    @Column(nullable = true)
    private Integer state;

    @ManyToOne
    @JoinColumn(name = "reg_no", nullable = false, referencedColumnName = "reg_no")
    private Hospital_By_Rdhs hospital_by_rdhs;


    @ManyToOne
    @JoinColumn(name = "sr_no", nullable = false, referencedColumnName = "sr_no")
    private Medicine medicine;


}
