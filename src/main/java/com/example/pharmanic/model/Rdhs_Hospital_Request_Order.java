package com.example.pharmanic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "Rdhs_Hospital_Request_Order")
public class Rdhs_Hospital_Request_Order {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long orderId;
    private String date;
    private String rdhs_id;
    private String trackId;

    @ManyToOne
    @JoinColumn(name = "reg_no", referencedColumnName = "reg_no")
    private Hospital_By_Rdhs hospital_by_rdhs;



}
