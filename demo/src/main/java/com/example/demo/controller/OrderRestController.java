package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.IOrderService;
import javafx.css.Styleable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/orders")
@CrossOrigin("*")
public class OrderRestController {
    @Autowired
    private IOrderService iOrderService;

    @GetMapping("")
    public ResponseEntity<List<Order>> getAllOrder(){
        return new ResponseEntity<>(iOrderService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Order>> search(@RequestParam("p") Integer product,@RequestParam("d") String dayOrder){
        return new ResponseEntity<>(iOrderService.searchOrder(product,dayOrder), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrder(@PathVariable("id") Integer id){
        iOrderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }
    @PostMapping("")
    public void createOrder( @RequestBody  Order order){
       iOrderService.createOrder(order);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") Integer id){
        return new ResponseEntity<>(iOrderService.getById(id), HttpStatus.OK);
    }
    @PutMapping("")
    public void editOrder(@RequestBody  Order order){
        iOrderService.edit(order);
    }
}
