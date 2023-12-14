package com.instagrocer.order.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.instagrocer.order.entity.OrderEntity;

import jakarta.transaction.Transactional;

@Transactional
public interface OrderDAO extends CrudRepository< OrderEntity, Integer >{
    @Query(name = "getOrderById")
    OrderEntity getOrderById(int orderId);
}
