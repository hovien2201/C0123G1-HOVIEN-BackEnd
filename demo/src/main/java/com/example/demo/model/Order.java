package com.example.demo.model;

import org.springframework.lang.NonNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "orders")
public class Order implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Không được để trống")
    private String dayOrder;
    @NotBlank(message = "Không được để trống")
    @Min(value = 0,message = "Phải lớn hơn 0")
    private Integer totalMoney;
    @NotBlank(message = "Không được để trống")
    @Min(value = 0,message = "Phải lớn hơn 0")
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Order() {
    }


    public Order(Integer id, String dayOrder, Integer totalMoney, Integer quantity, Product product) {
        this.id = id;
        this.dayOrder = dayOrder;
        this.totalMoney = totalMoney;
        this.quantity = quantity;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDayOrder() {
        return dayOrder;
    }

    public void setDayOrder(String dayOrder) {
        this.dayOrder = dayOrder;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
