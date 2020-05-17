package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Ministry_Available_Stock {
    private @Id @GeneratedValue Long id;

    private String name;
    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "m_store_id",referencedColumnName = "m_store_id")
    private Ministry_Store m_store_id;

    @ManyToOne
    @JoinColumn(name = "sr_no",referencedColumnName = "sr_no")
    private Medicine sr_no;

}
