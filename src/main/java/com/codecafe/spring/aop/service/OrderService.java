package com.codecafe.spring.aop.service;

import com.codecafe.spring.aop.entity.Order;
import com.codecafe.spring.aop.model.CreateOrderRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;
import java.util.Random;

@Service
public class OrderService {

  private final Map<Integer, Order> orders;

  public OrderService(Map<Integer, Order> orders) {
    this.orders = orders;
  }

  public Order createOrder(CreateOrderRequest createOrderRequest) {
    int orderId = new Random().nextInt(10000);

    Order order = Order.builder()
                       .id(orderId)
                       .date(LocalDate.now())
                       .items(createOrderRequest.getItems())
                       .build();

    orders.put(orderId, order);

    return order;
  }

  public Order getOrderDetails(int orderId) {
    return orders.get(orderId);
  }

}
