package com.codecafe.spring.aop.controller;

import com.codecafe.spring.aop.entity.Order;
import com.codecafe.spring.aop.model.CreateOrderRequest;
import com.codecafe.spring.aop.model.CreateOrderResponse;
import com.codecafe.spring.aop.model.GetOrderResponse;
import com.codecafe.spring.aop.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping
  ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
    Order order = orderService.createOrder(createOrderRequest);
    return new ResponseEntity<>(order.toCreateOrderResponse(), HttpStatus.CREATED);
  }

  @GetMapping("/{orderId}")
  ResponseEntity<GetOrderResponse> getOrderDetails(@PathVariable("orderId") int orderId) {
    Order order = orderService.getOrderDetails(orderId);
    return ResponseEntity.ok(order.toGetOrderResponse());
  }

}
