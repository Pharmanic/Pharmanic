package com.example.pharmanic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@ToString
@Table(name = "Rdhs_Hospital_Current_Stock")
public class Rdhs_Hospital_Current_Stock {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long stockId;
    private Long batchNo;
    private Integer quantity;
    private String expiredate;



    @ManyToOne
    @JoinColumn(name = "reg_no", referencedColumnName = "reg_no")
    private Hospital_By_Rdhs hospital_by_rdhs;


    @ManyToOne
    @JoinColumn(name = "sr_no", nullable = false, referencedColumnName = "sr_no")
    private Medicine medicine;

    @Override
    public String toString() {
        return "Rdhs_Hospital_Current_Stock{" +
                "stockId=" + stockId +
                ", batchNo=" + batchNo +
                ", quantity=" + quantity +
                ", expiredate='" + expiredate + '\'' +
                ", hospital_by_rdhs=" + hospital_by_rdhs +
                ", medicine=" + medicine +
                '}';
    }
}
