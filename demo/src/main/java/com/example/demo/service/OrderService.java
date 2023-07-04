package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.repository.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderService implements IOrderService{
    @Autowired
    private IOrderRepo iOrderRepo;

    @Override
    public List<Order> getAll() {
        return iOrderRepo.getAll();
    }
    @Modifying
    @Transactional
    @Override
    public void deleteOrder(Integer id) {
         iOrderRepo.deleteById(id);
    }

    @Override
    public Boolean createOrder(Order orders) {
        iOrderRepo.createOrder(orders.getDayOrder(),orders.getQuantity(),orders.getTotalMoney(),orders.getProduct().getId());
        return true;
    }

    @Override
    public Order getById(int id) {
        return iOrderRepo.getOrderById(id);
    }

    @Override
    public void edit(Order orders) {
        iOrderRepo.updateOrder(orders.getDayOrder(),orders.getQuantity(),orders.getTotalMoney(),orders.getProduct().getId(),orders.getId());
    }

    @Override
    public List<Order> searchOrder(Integer product, String dayOrder) {
//        return iOrderRepo.searchOrder(product,dayOrder);
        return null;
    }

}
