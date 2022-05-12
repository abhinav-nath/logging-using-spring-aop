package com.codecafe.spring.aop.service;

import com.codecafe.spring.aop.entity.Order;
import com.codecafe.spring.aop.model.CreateOrderRequest;
import com.codecafe.spring.aop.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;

@Service
public class OrderService {

  private final OrderRepository orderRepository;

  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public Order createOrder(CreateOrderRequest createOrderRequest) {
    int orderId = new Random().nextInt(10000);

    Order order = Order.builder()
                       .id(orderId)
                       .date(LocalDate.now())
                       .items(createOrderRequest.getItems())
                       .build();

    return orderRepository.save(order);
  }

  public Order getOrderDetails(int orderId) {
    return orderRepository.findById(orderId);
  }

}
