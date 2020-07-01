package com.example.pharmanic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "Rdhs_Hospital_Issued_Drugs")
public class Rdhs_Hospital_Issued_Drugs {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long Id;
    private String Date;
    private Integer qty;

    @ManyToOne
    @JoinColumn(name = "reg_no", nullable = false, referencedColumnName = "reg_no")
    private Hospital_By_Rdhs hospital_by_rdhs;

    @ManyToOne
    @JoinColumn(name = "stockId" ,referencedColumnName = "stockId")
    private Rdhs_Hospital_Current_Stock rdhs_hospital_current_stock;

}
