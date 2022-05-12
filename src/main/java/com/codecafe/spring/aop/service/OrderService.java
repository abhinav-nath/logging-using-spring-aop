package com.codecafe.spring.aop.service;

import com.codecafe.spring.aop.entity.Order;
import com.codecafe.spring.aop.error.OrderNotFoundException;
import com.codecafe.spring.aop.model.CreateOrderRequest;
import com.codecafe.spring.aop.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderService {

  private final OrderRepository orderRepository;

  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public Order createOrder(CreateOrderRequest createOrderRequest) {
    Order order = Order.builder()
                       .date(LocalDate.now())
                       .items(createOrderRequest.getItems())
                       .build();

    return orderRepository.save(order);
  }

  public Order getOrderDetails(int orderId) {
    return orderRepository.findById(orderId).orElseThrow(() ->
      new OrderNotFoundException(String.format("Order with id [%d] does not exist", orderId)));
  }

}
