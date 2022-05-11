package com.codecafe.spring.aop.controller;

import com.codecafe.spring.aop.entity.Order;
import com.codecafe.spring.aop.model.CreateOrderRequest;
import com.codecafe.spring.aop.model.CreateOrderResponse;
import com.codecafe.spring.aop.model.GetOrderResponse;
import com.codecafe.spring.aop.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping
  ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
    Order createdOrder = orderService.createOrder(createOrderRequest);
    CreateOrderResponse createOrderResponse = createdOrder.toCreateOrderResponse();
    return new ResponseEntity<>(createOrderResponse, HttpStatus.CREATED);
  }

  @GetMapping("/{orderId}")
  ResponseEntity<GetOrderResponse> getOrderDetails(@PathVariable("orderId") int orderId) {
    Order order = orderService.getOrderDetails(orderId);
    GetOrderResponse getOrderResponse = order.toGetOrderResponse();
    return ResponseEntity.ok(getOrderResponse);
  }

}
