package com.example.pharmanic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Rdhs_Hospital_Return_Drug")
public class Rdhs_Hospital_Return_Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    private int quantity;
    private int state;
    private int track_id;

    @ManyToOne
    @JoinColumn(name = "reg_no", nullable = false, referencedColumnName = "reg_no")
    private Hospital_By_Rdhs hospital_by_rdhs;

    @ManyToOne
    @JoinColumn(name = "batchId", nullable = false, referencedColumnName = "batchId")
    private Rdhs_Hospital_Current_Stock rdhs_hospital_current_stock;

}
