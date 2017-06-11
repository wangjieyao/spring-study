package springstudy.pizza.service;


import springstudy.pizza.domain.Order;

public interface PricingEngine {
  public float calculateOrderTotal(Order order);
}
