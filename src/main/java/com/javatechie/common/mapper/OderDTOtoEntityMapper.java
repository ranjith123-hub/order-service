package com.javatechie.common.mapper;

import com.javatechie.common.dto.OrderRequestDTO;
import com.javatechie.entity.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OderDTOtoEntityMapper {
    public Order map(OrderRequestDTO orderRequestDto) {
        return Order.builder()
                .customerId(orderRequestDto.getCustomerId())
                .name(orderRequestDto.getName())
                .productType(orderRequestDto.getProductType())
                .quantity(orderRequestDto.getQuantity())
                .price(orderRequestDto.getPrice())
                .orderDate(new Date())
                .build();
    }
}
