package com.instagrocer.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagrocer.order.business.OrderBean;
import com.instagrocer.order.dao.OrderDAOWrapper;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDAOWrapper orderDAOWrapper;

    @Override
    public OrderBean getOrderById(int orderId){
        return orderDAOWrapper.getOrderById(orderId);
    }

    @Override
    public String placeOrder(OrderBean orderItem){
        return orderDAOWrapper.placeOrder(orderItem);
    }
}
