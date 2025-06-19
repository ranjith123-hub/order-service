package com.javatechie.repository;

import com.javatechie.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long>{
}
