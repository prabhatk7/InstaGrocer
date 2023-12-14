package com.instagrocer.order.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.instagrocer.order.entity.ItemEntity;

import jakarta.transaction.Transactional;

@Transactional
public interface ItemDAO extends CrudRepository<ItemEntity, Integer> {
    @Query(name = "findItemByName")
    ItemEntity findByName(String name);
}
