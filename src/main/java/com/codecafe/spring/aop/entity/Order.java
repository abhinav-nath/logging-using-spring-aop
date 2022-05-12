package com.codecafe.spring.aop.entity;

import com.codecafe.spring.aop.model.CreateOrderResponse;
import com.codecafe.spring.aop.model.GetOrderResponse;
import com.codecafe.spring.aop.model.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

  private int id;
  private LocalDate date;
  private List<Item> items;

  public CreateOrderResponse toCreateOrderResponse() {
    return CreateOrderResponse.builder()
                              .orderId(id)
                              .orderDate(date)
                              .items(items)
                              .build();
  }

  public GetOrderResponse toGetOrderResponse() {
    return GetOrderResponse.builder()
                           .orderId(id)
                           .orderDate(date)
                           .items(items)
                           .build();
  }

}
