package com.codecafe.spring.aop.repository;

import com.codecafe.spring.aop.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Repository
public class OrderRepository {

  private final Random random;
  private final Map<Integer, Order> orders;

  public OrderRepository(Map<Integer, Order> orders) {
    this.random = new Random();
    this.orders = orders;
  }

  public Order save(Order order) {
    order.setId(random.nextInt(10000));
    orders.put(order.getId(), order);
    return order;
  }

  public Optional<Order> findById(int orderId) {
    if (orders.get(orderId) == null) {
      return Optional.empty();
    }
    return Optional.of(orders.get(orderId));
  }

}
