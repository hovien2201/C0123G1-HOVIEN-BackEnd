package com.example.demo.service;

import com.example.demo.model.Order;

import java.util.List;

public interface IOrderService {
    List<Order> getAll();

    void deleteOrder(Integer id);

    Boolean createOrder(Order order);

    Order getById(int id);

    void edit(Order order);

    List<Order> searchOrder(Integer product, String dayOrder);
}
