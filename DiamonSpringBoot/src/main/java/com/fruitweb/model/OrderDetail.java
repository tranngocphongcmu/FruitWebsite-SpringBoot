package com.fruitweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orderdetails")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderdetail_id")
	private Long id;
	
	@ManyToOne()
	@JoinColumn(name = "order_id",referencedColumnName = "order_id")
	private Order order;
	
	@ManyToOne()
	@JoinColumn(name = "product_id",referencedColumnName = "product_id")
	private Product product;

}
