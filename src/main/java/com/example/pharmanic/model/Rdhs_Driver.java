package com.example.pharmanic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Rdhs_Driver")
public class Rdhs_Driver {

    private @Id
    String nic;

    private String name;
    private String email;
    private String address;
    private String telephone;


    @ManyToOne
    @JoinColumn(name = "reg_no", nullable = false, referencedColumnName = "reg_no")
    private Rdhs rdhs;
}
