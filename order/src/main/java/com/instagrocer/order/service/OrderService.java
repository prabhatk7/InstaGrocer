package com.instagrocer.order.service;

import com.instagrocer.order.business.OrderBean;

public interface OrderService {
    OrderBean getOrderById(int orderId);
    String placeOrder(OrderBean orderItem);
}
