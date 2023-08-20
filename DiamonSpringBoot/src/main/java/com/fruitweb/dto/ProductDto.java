package com.fruitweb.dto;

import com.fruitweb.model.BillDetail;
import com.fruitweb.model.Category;
import com.fruitweb.model.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

public class ProductDto {


        private Long id;
        private String name;
        private int currentQuantity;
        private double costPrice;
        private double salePrice;
        private MultipartFile image;

        private Category category;

        private List<OrderDetail> orderDetails;

        private List<BillDetail> billDetails;

    public ProductDto() {
    }

    public ProductDto(Long id, String name, int currentQuantity, double costPrice, double salePrice, MultipartFile image, Category category, List<OrderDetail> orderDetails, List<BillDetail> billDetails) {

        this.id = id;
        this.name = name;
        this.currentQuantity = currentQuantity;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.image = image;
        this.category = category;
        this.orderDetails = orderDetails;
        this.billDetails = billDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<BillDetail> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(List<BillDetail> billDetails) {
        this.billDetails = billDetails;
    }
}
