package com.fruitweb.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bills")
public class Bills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bills_id")
    private Long id;
    private String email;
    private String phone;
    private String password;
    private String name;
    private String address;
    private double total;
    private int quanty;
    private String note;

    @OneToMany(mappedBy = "bills")
    private List<BillDetail> billDetails;
}
