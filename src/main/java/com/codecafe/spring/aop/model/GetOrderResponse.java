package com.codecafe.spring.aop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetOrderResponse {

  private int orderId;
  private List<Item> items;
  private LocalDate orderDate;

}