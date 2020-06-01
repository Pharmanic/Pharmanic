package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Rdhs_Vehicle")
public class Rdhs_Vehicle {
    private @Id
    String vehicle_no;
    private String type;
    private Long capacity;

    @ManyToOne
    @JoinColumn(name = "reg_no", nullable = false, referencedColumnName = "reg_no")
    private Rdhs rdhs;

}
