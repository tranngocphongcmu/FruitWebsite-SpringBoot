package com.fruitweb.model;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long id;
	private String name;
	private int currentQuantity;
    private double costPrice;
    private double salePrice;
    private String image;

	@ManyToOne()
    @JoinColumn(name = "category_id",referencedColumnName = "category_id")
    private Category category;
    
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "product")
    private List<BillDetail> billDetails;

    public Product(Long id, String name, int currentQuantity, double costPrice, double salePrice, MultipartFile image) {
    }




}
