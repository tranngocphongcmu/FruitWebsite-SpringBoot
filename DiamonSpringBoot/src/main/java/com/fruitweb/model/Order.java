package com.fruitweb.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
    private Long id;
    private String status;
    private String userName;
    private String userEmail;
    private String userPhone;
    private double total;
    private int quantity;
    private boolean is_payment;
    
    @ManyToOne()
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private User user;
    
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

}
