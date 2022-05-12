package com.codecafe.spring.aop.repository;

import com.codecafe.spring.aop.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class OrderRepository {

  private final Map<Integer, Order> orders;

  public OrderRepository(Map<Integer, Order> orders) {
    this.orders = orders;
  }

  public Order save(Order order) {
    orders.put(order.getId(), order);
    return order;
  }

  public Order findById(int orderId) {
    return orders.get(orderId);
  }

}
