package com.instagrocer.order.dao;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.instagrocer.order.business.OrderBean;
import com.instagrocer.order.entity.ItemEntity;
import com.instagrocer.order.entity.OrderEntity;

@Component
public class OrderDAOWrapper {
    @Autowired
    OrderDAO orderDAO;
    @Autowired
    ItemDAO itemDAO;

    private OrderBean convertEntityToBean(OrderEntity entity){
        OrderBean bean = new OrderBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    private OrderEntity convertBeanToEntity(OrderBean bean){
        OrderEntity entity = new OrderEntity();
        BeanUtils.copyProperties(bean, entity);
        return entity;
    }

    public OrderBean getOrderById(int orderId){
        OrderEntity entity = orderDAO.getOrderById(orderId);
        OrderBean bean = convertEntityToBean(entity);
        return bean;
    }

    public String placeOrder(OrderBean orderItem){
        ItemEntity item = itemDAO.findByName(orderItem.getItemName());
        if(item == null)
        return "No such item in inventory!";
        if(item.getQuantity()<orderItem.getQuantity())
        return "Insufficient quantity in inventory. Available quantity: "+ item.getQuantity();

        OrderEntity orderEntity = convertBeanToEntity(orderItem);
        orderEntity.setAmount(item.getPrice()*orderItem.getQuantity());
        orderEntity = orderDAO.save(orderEntity);
        
        item.setQuantity(item.getQuantity()-orderEntity.getQuantity());
        itemDAO.save(item);

        return "Order placed for "+ orderItem.getItemName()+"! . Your order id is: "+orderEntity.getOrderId();
    }
}
