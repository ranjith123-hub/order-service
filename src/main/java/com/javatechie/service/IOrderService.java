package com.javatechie.service;

import com.javatechie.common.dto.OrderRequestDTO;
import com.javatechie.entity.Order;

public interface IOrderService {
    // create order
    public Order creatdOrder(OrderRequestDTO orderRequestDto);

    // get order by id
    public Order getOrderById(Long id);

}
