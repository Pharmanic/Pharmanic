package com.example.pharmanic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "LM_Hospital_Request_Order")
public class LM_Hospital_Request_Order {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long orderId;
    private String date;

    @ManyToOne
    @JoinColumn(name = "reg_no", referencedColumnName = "reg_no")
    private Direct_Hospital direct_hospital;



}
