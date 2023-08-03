package com.fruitweb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "billdetail")
public class BillDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "billdetail_id")
    private Long id;
//    private Long id_product;
//    private Long id_bills;
    private int quanty;
    private double total;

    @ManyToOne()
    @JoinColumn(name = "bills_id",referencedColumnName = "bills_id")
    private Bills bills;

    @ManyToOne()
    @JoinColumn(name = "product_id",referencedColumnName = "product_id")
    private Product product;

}
