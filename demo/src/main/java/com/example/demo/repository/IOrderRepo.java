package com.example.demo.repository;

import com.example.demo.model.Order;
import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface IOrderRepo extends JpaRepository<Order, Integer> {
    @Query(value = "SELECT o from Order  o")
    List<Order> getAll();
    @Query(value = "delete from Order  o where o.id = :id" )
    void deleteOrder(@Param("id")int id);

    @Query(value = "select o from Order  o where o.id = :id" )
    Order getOrderById(@Param("id")int id);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO orders(day_order,`quantity`,`total_money`,product_id) VALUES(:day_order,:quantity,:total_money,:product_id)", nativeQuery = true)
    void createOrder(@Param("day_order") String day_order, @Param("quantity") Integer quantity,
                     @Param("total_money") Integer total_money, @Param("product_id") Integer product_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE orders o SET day_order =:day_order, quantity =:quantity, total_money=:total_money, product_id=:product_id WHERE o.id =:id", nativeQuery = true)
    void updateOrder(@Param("day_order") String day_order, @Param("quantity") Integer quantity,
                     @Param("total_money") Integer total_money, @Param("product_id") Integer product_id ,@Param("id") Integer id);

//    @Query(value = "SELECT o FROM Order o WHERE o.product = :product")
//    List<Order> searchOrder(@Param("product")Integer product,@Param("day_order") String day_order);
}
