package com.javatechie.service.impl;

import com.javatechie.common.dto.OrderRequestDTO;
import com.javatechie.common.mapper.OderDTOtoEntityMapper;
import com.javatechie.common.mapper.OrderEntityToOutboxEntityMapper;
import com.javatechie.entity.Order;
import com.javatechie.entity.Outbox;
import com.javatechie.repository.IOrderRepository;
import com.javatechie.repository.IOutboxRepository;
import com.javatechie.service.IOrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OderDTOtoEntityMapper orderDTOtoEntityMapper;
    @Autowired
    private IOrderRepository orderRepository;
    @Autowired
    private IOutboxRepository outboxRepository;
    @Autowired
    private OrderEntityToOutboxEntityMapper orderEntityToOutboxEntityMapper;

    @Transactional
    public Order creatdOrder(OrderRequestDTO orderRequestDto){
        // persist order to database
        Order order = orderDTOtoEntityMapper.map(orderRequestDto);
        order= orderRepository.save(order);

        // to see Transactional annotation in action or not, we force an Arithmatic exception here
       // System.out.println(1/0);
        // persist order to outbox(used for event sourcing)
        Outbox outbox = orderEntityToOutboxEntityMapper.map(order);
        outboxRepository.save(outbox);
        return null;
    }

    @Override
    public Order getOrderById(Long id) {
        // fetch order by id
        Order order = orderRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Order not found with id: " + id));
        return order;
    }
}
