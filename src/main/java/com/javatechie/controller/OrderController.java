package com.javatechie.controller;

import com.javatechie.common.dto.OrderRequestDTO;
import com.javatechie.entity.Order;
import com.javatechie.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/orders")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderServiceImpl;

    // create order

   @PostMapping
  public ResponseEntity<Order> createOrder(@RequestBody OrderRequestDTO orderRequest){
       Order createdOrder = orderServiceImpl.creatdOrder(orderRequest);
       return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
   }
    // get order by id
     @GetMapping("/{id}")
     public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
         Order order = orderServiceImpl.getOrderById(id);
            return ResponseEntity.ok(order);
     }
}
